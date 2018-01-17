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
    private RadioGroup qx1RadioGroup,qx2RadioGroup,qx3RadioGroup,qx4RadioGroup,qx5RadioGroup,qx6RadioGroup;
    private RadioGroup qx7RadioGroup,qx8RadioGroup,qx9RadioGroup,qx10RadioGroup,qx11RadioGroup,qx12RadioGroup;

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

        qx2RadioGroup = findViewById(R.id.qx2);
        qx2RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx2_1) {

                } else if (checkedId == R.id.qx2_2) {

                } else if (checkedId == R.id.qx2_3) {

                }
            }
        });

        qx3RadioGroup = findViewById(R.id.qx3);
        qx3RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx3_1) {

                } else if (checkedId == R.id.qx3_2) {

                } else if (checkedId == R.id.qx3_3) {

                } else if (checkedId == R.id.qx3_4) {

                }
            }
        });

        qx4RadioGroup = findViewById(R.id.qx4);
        qx4RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx4_1) {

                } else if (checkedId == R.id.qx4_2) {

                } else if (checkedId == R.id.qx4_3) {

                } else if (checkedId == R.id.qx4_4) {

                }
            }
        });

        qx5RadioGroup = findViewById(R.id.qx5);
        qx5RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx5_1) {

                } else if (checkedId == R.id.qx5_2) {

                } else if (checkedId == R.id.qx5_3) {

                } else if (checkedId == R.id.qx5_4) {

                }
            }
        });

        qx6RadioGroup = findViewById(R.id.qx6);
        qx6RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx6_1) {

                } else if (checkedId == R.id.qx6_2) {

                } else if (checkedId == R.id.qx6_3) {

                } else if (checkedId == R.id.qx6_4) {

                }
            }
        });

        qx7RadioGroup = findViewById(R.id.qx7);
        qx7RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx7_1) {

                } else if (checkedId == R.id.qx7_2) {

                } else if (checkedId == R.id.qx7_3) {

                } else if (checkedId == R.id.qx7_4) {

                }
            }
        });

        qx8RadioGroup = findViewById(R.id.qx8);
        qx8RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx8_1) {

                } else if (checkedId == R.id.qx8_2) {

                } else if (checkedId == R.id.qx8_3) {

                } else if (checkedId == R.id.qx8_4) {

                }
            }
        });

        qx9RadioGroup = findViewById(R.id.qx9);
        qx9RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx9_1) {

                } else if (checkedId == R.id.qx9_2) {

                } else if (checkedId == R.id.qx9_3) {

                } else if (checkedId == R.id.qx9_4) {

                }
            }
        });

        qx10RadioGroup = findViewById(R.id.qx10);
        qx10RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx10_1) {

                } else if (checkedId == R.id.qx10_2) {

                } else if (checkedId == R.id.qx10_3) {

                } else if (checkedId == R.id.qx10_4) {

                }
            }
        });

        qx11RadioGroup = findViewById(R.id.qx11);
        qx11RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx11_1) {

                } else if (checkedId == R.id.qx11_2) {

                } else if (checkedId == R.id.qx11_3) {

                } else if (checkedId == R.id.qx11_4) {

                }
            }
        });

        qx12RadioGroup = findViewById(R.id.qx12);
        qx12RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx12_1) {

                } else if (checkedId == R.id.qx12_2) {

                } else if (checkedId == R.id.qx12_3) {

                } else if (checkedId == R.id.qx12_4) {

                }
            }
        });
    }


}
