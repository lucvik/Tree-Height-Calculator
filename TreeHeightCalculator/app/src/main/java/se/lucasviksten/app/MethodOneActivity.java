package se.lucasviksten.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MethodOneActivity extends Fragment implements View.OnClickListener {
    private EditText distanceView;
    private EditText topAngleView;
    private EditText rootAngleView;
    private RadioButton negativeAngleView;
    private RadioButton positiveAngleView;
    private Button calculate;
    private TextView result;

    private String distance;
    private String topAngle;
    private String rootAngle;

    private double e;   // distance to tree
    private double a1;  // top angle
    private double a2;  // root angle
    private double h;   // height

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_method_one, container, false);

        distanceView = (EditText) rootView.findViewById(R.id.edit_distance);
        topAngleView = (EditText) rootView.findViewById(R.id.edit_tree_top_angle);
        rootAngleView = (EditText) rootView.findViewById(R.id.edit_tree_root_angle);
        negativeAngleView = (RadioButton) rootView.findViewById(R.id.radio_negative);
        positiveAngleView = (RadioButton) rootView.findViewById(R.id.radio_positive);
        calculate = (Button) rootView.findViewById(R.id.button_calculate);
        result = (TextView) rootView.findViewById(R.id.text_result);

        calculate.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        // Reset errors.
        distanceView.setError(null);

        boolean cancel = false;
        View focusView = null;

        // Store input values.
        distance = distanceView.getText().toString();
        topAngle = topAngleView.getText().toString();
        rootAngle = rootAngleView.getText().toString();

        // Check if fields are empty.
        if(TextUtils.isEmpty(distance)) {
            distanceView.setError("Tomt fält.");
            focusView = distanceView;
            cancel = true;
        }

        if(TextUtils.isEmpty(topAngle)) {
            topAngleView.setError("Tomt fält.");
            focusView = topAngleView;
            cancel = true;
        }

        if(TextUtils.isEmpty(rootAngle)) {
            rootAngleView.setError("Tomt fält.");
            focusView = rootAngleView;
            cancel = true;
        }

        if(cancel) {
            // A field is empty; sets focus on empty field and display error.
            focusView.requestFocus();
        } else {
            calcHeight();
        }
    }

    // Function for calculating height.
    public void calcHeight() {
        e = Double.parseDouble(distance);
        a1 = Double.parseDouble(topAngle);
        a2 = Double.parseDouble(rootAngle);

        // Checks if root angle is negative or positive.
        if(positiveAngleView.isChecked()) {
            h = e * (Math.tan(Math.toRadians(a1)) - Math.tan(Math.toRadians(a2)));
        } else {
            h = e * (Math.tan(Math.toRadians(a1)) - Math.tan(Math.toRadians(-a2)));
        }

        // Rounds height to two decimals.
        h = (double)Math.round(h * 100) / 100;

        // Prints result.
        result.setText(h + " meter");
    }
}
