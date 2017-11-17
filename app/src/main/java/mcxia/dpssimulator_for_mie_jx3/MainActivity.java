package mcxia.dpssimulator_for_mie_jx3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import mcxia.dpssimulator_for_mie_jx3.PersonalAttribute;

/**
 * Created by pipiyby on 11/16/17.
 * View block
 */

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute);

        Button simulation = findViewById(R.id.simulator_button);
        final EditText GJ_Num = findViewById(R.id.GJ_number);
        final EditText SF_Num = findViewById(R.id.SF_number);
        final EditText HXN_Num = findViewById(R.id.HXN_number);
        final EditText HXO_Num = findViewById(R.id.HXO_number);
        final EditText JS_Num = findViewById(R.id.JS_number);
        final EditText MZ_Num = findViewById(R.id.MZ_number);
        final EditText WS_Num = findViewById(R.id.WS_number);

        simulation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PersonalAttribute myPA = new PersonalAttribute(getNum(GJ_Num), getNum(SF_Num), getNum(HXN_Num), getNum(HXO_Num), getNum(JS_Num), getNum(MZ_Num), getNum(WS_Num));

            }
        });
    }

    private double getNum(EditText myEdit){
        String mytext = myEdit.getText().toString();
        return Double.parseDouble(mytext);
    }

}
