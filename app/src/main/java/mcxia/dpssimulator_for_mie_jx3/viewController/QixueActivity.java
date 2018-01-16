package mcxia.dpssimulator_for_mie_jx3.viewController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.io.InputStream;

import mcxia.dpssimulator_for_mie_jx3.R;
import mcxia.dpssimulator_for_mie_jx3.model.Mie;

/**
 * Created by pipiyby on 1/10/18.
 */

public class QixueActivity extends Activity {
    private RadioGroup qx1RadioGroup;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qixue);
        initView();

        Button gotoMiji = findViewById(R.id.simulator_button);
        gotoMiji.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MijiActivity.class);
                startActivity(i);
            }
        });
    }

    private void initView() {
        /** RadioGroup and RadioButton **/
        qx1RadioGroup = findViewById(R.id.qx1);
        qx1RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx1_1) {

                } else if (checkedId == R.id.qx1_2) {

                } else if (checkedId == R.id.qx1_3) {
                    
                }
            }
        });
    }


}
