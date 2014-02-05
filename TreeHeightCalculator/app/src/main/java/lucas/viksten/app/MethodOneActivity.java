package lucas.viksten.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MethodOneActivity extends Fragment implements View.OnClickListener {
    private EditText distance;
    private EditText topAngle;
    private EditText rootAngle;
    private RadioButton negativeAngle;
    private RadioButton positiveAngle;
    private Button calculate;
    private TextView result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_method_one, container, false);

        distance = (EditText) rootView.findViewById(R.id.edit_distance);
        topAngle = (EditText) rootView.findViewById(R.id.edit_tree_top_angle);
        rootAngle = (EditText) rootView.findViewById(R.id.edit_tree_root_angle);
        negativeAngle = (RadioButton) rootView.findViewById(R.id.radio_negative);
        positiveAngle = (RadioButton) rootView.findViewById(R.id.radio_positive);
        calculate = (Button) rootView.findViewById(R.id.button_calculate);
        result = (TextView) rootView.findViewById(R.id.text_result);

        calculate.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        if (positiveAngle.isChecked()) {
            result.setText("TEST POS");
        } else {
            result.setText("TEST NEG");
        }
    }
}
