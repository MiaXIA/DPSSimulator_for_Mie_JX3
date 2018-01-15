package mcxia.dpssimulator_for_mie_jx3.viewController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.InputStream;

import mcxia.dpssimulator_for_mie_jx3.R;
import mcxia.dpssimulator_for_mie_jx3.model.Mie;

/**
 * Created by pipiyby on 1/10/18.
 */

public class QixueActivity extends Activity {

    private CheckBox qx1_1, qx1_2, qx1_3, qx2_1, qx2_2, qx2_3, qx3_1, qx3_2, qx3_3, qx4_1, qx4_2, qx4_3, qx5_1, qx5_2, qx5_3;
    private CheckBox qx6_1, qx6_2, qx6_3, qx7_1, qx7_2, qx7_3, qx8_1, qx8_2, qx8_3, qx9_1, qx9_2, qx9_3, qx10_1, qx10_2, qx10_3;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qixue);

        Button gotoMiji = findViewById(R.id.simulator_button);
        gotoMiji.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), MijiActivity.class);
                startActivity(i);
            }
        });
    }
}
