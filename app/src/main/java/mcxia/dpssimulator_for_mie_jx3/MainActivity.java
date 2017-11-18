package mcxia.dpssimulator_for_mie_jx3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import mcxia.dpssimulator_for_mie_jx3.model.DPSCalculator;
import mcxia.dpssimulator_for_mie_jx3.model.PersonalAttribute;

/**
 * Created by pipiyby on 11/16/17.
 * Controller block
 */

public class MainActivity extends AppCompatActivity{

    private EditText GJ_Num, SF_Num, HXN_Num, HXO_Num, JS_Num, MZ_Num, WS_Num;
    private Button simulation;
    private DPSCalculator myCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute);

        simulation = findViewById(R.id.simulator_button);
        GJ_Num = findViewById(R.id.GJ_number);
        SF_Num = findViewById(R.id.SF_number);
        HXN_Num = findViewById(R.id.HXN_number);
        HXO_Num = findViewById(R.id.HXO_number);
        JS_Num = findViewById(R.id.JS_number);
        MZ_Num = findViewById(R.id.MZ_number);
        WS_Num = findViewById(R.id.WS_number);

        simulation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //PersonalAttribute myPA = new PersonalAttribute(getNum(GJ_Num), getNum(SF_Num), getNum(HXN_Num), getNum(HXO_Num), getNum(JS_Num), getNum(MZ_Num), getNum(WS_Num));

            }
        });
    }

    private double getNumd(EditText myEdit){
        String mytext = myEdit.getText().toString();
        return Double.parseDouble(mytext);
    }

    private int getNum(EditText myEdit){
        String mytext = myEdit.getText().toString();
        return Integer.parseInt(mytext);
    }

}
