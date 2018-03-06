package mcxia.dpssimulator_for_mie_jx3.viewController;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import mcxia.dpssimulator_for_mie_jx3.R;
import mcxia.dpssimulator_for_mie_jx3.model.Mie;

/**
 * Created by pipiyby on 1/11/18.
 */

public class MijiActivity extends AppCompatActivity {
    private CheckBox c11,c12,c13,c14,c15,c16,c17,c18;
    private CheckBox c21,c22,c23,c24,c25,c26,c27,c28,c29;
    private CheckBox c31,c32,c33,c34,c35,c36,c37,c38,c39;
    private CheckBox c41,c42,c43,c44,c45,c46,c47,c48;
    private int bhgyChecked, wwwjChecked, shtyChecked, rjhyChecked;
  
    private Button gotoResult;
    private Mie mymie;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miji);
        SharedPreferences sharedpreferences = getSharedPreferences("tempjineng", Context.MODE_PRIVATE);
        mymie = new Mie();
        mymie.loadModel(sharedpreferences, null);
        InputStream is = getResources().openRawResource(R.raw.jineng);
        mymie.InitJiNeng(is);
        Button gotoResult = findViewById(R.id.gotoresult_button);
        gotoResult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (c11.isChecked()) {
                    //调息-1s
                    mymie.getJN().get("bhgy").minusCd(1.0);
                }
                if (c12.isChecked()) {
                    //蓝耗-5%
                    //mymie.getJN().get("bhgy").minusMana(0.95);
                }
                if (c13.isChecked()) {
                    //蓝耗-10%
                    //mymie.getJN().get("bhgy").minusMana(0.9);
                }
                if (c14.isChecked()) {
                    //伤害+3%
                    mymie.getJN().get("bhgy").addPercent(3);
                }
                if (c15.isChecked()) {
                    //伤害+4%
                    mymie.getJN().get("bhgy").addPercent(4);
                }
                if (c16.isChecked()) {
                    //伤害+5%
                    mymie.getJN().get("bhgy").addPercent(5);
                }
                if (c17.isChecked()) {
                    //命中+2%
                    mymie.getJN().get("bhgy").addBonusmingzhong(2.0);
                }
                if (c18.isChecked()) {
                    //命中+0.5气

                }
                if (c21.isChecked()) {
                    //会心+2%
                    mymie.getJN().get("wwwj").addHuixin(2.0);
                }
                if (c22.isChecked()) {
                    //会心+3%
                    mymie.getJN().get("wwwj").addHuixin(3.0);
                }
                if (c23.isChecked()) {
                    //会心+4%
                    mymie.getJN().get("wwwj").addHuixin(4.0);
                }
                if (c24.isChecked()) {
                    //伤害+3%
                    mymie.getJN().get("wwwj").addPercent(3);
                }
                if (c25.isChecked()) {
                    //伤害+4%
                    mymie.getJN().get("wwwj").addPercent(4);
                }
                if (c26.isChecked()) {
                    //伤害+5%
                    mymie.getJN().get("wwwj").addPercent(5);
                }
                if (c27.isChecked()) {
                    //命中+1%
                    mymie.getJN().get("wwwj").addBonusmingzhong(1.0);
                }
                if (c28.isChecked()) {
                    //命中+2%
                    mymie.getJN().get("wwwj").addBonusmingzhong(2.0);
                }
                if (c29.isChecked()) {
                    //命中+0.5气

                }
                if (c31.isChecked()) {
                    //调息-0.5s
                    mymie.getJN().get("shty").minusCd(0.5);
                }
                if (c32.isChecked()) {
                    //会心+2%
                    mymie.getJN().get("shty").addHuixin(2.0);
                }
                if (c33.isChecked()) {
                    //会心+3%
                    mymie.getJN().get("shty").addHuixin(3.0);
                }
                if (c34.isChecked()) {
                    //会心+4%
                    mymie.getJN().get("shty").addHuixin(4.0);
                }
                if (c35.isChecked()) {
                    //伤害+3%
                    mymie.getJN().get("shty").addPercent(3);
                }
                if (c36.isChecked()) {
                    //伤害+4%
                    mymie.getJN().get("shty").addPercent(3);
                }
                if (c37.isChecked()) {
                    //伤害+5%
                    mymie.getJN().get("shty").addPercent(3);
                }
                if (c38.isChecked()) {
                    //命中+1%
                    mymie.getJN().get("shty").addBonusmingzhong(1.0);
                }
                if (c39.isChecked()) {
                    //命中+2%
                    mymie.getJN().get("shty").addBonusmingzhong(2.0);
                }
                if (c41.isChecked()) {
                    //调息-2s
                    mymie.getJN().get("rjhy").minusCd(2.0);
                }
                if (c42.isChecked()) {
                    //调息-3s
                    mymie.getJN().get("rjhy").minusCd(3.0);
                }
                if (c43.isChecked()) {
                    //+dot，12s
                    //默认必选，已经加在正常函数里
                }
                if (c44.isChecked()) {
                    //伤害+40%
                    mymie.getJN().get("rjhy").addPercent(40);
                }
                if (c45.isChecked()) {
                    //伤害+60%
                    mymie.getJN().get("bhgy").addPercent(60);
                }
                if (c46.isChecked()) {
                    //距离+1
                    //默认站撸怪！！！
                }
                if (c47.isChecked()) {
                    //距离+1
                    //默认站撸怪！！！
                }
                if (c48.isChecked()) {
                    //距离+1
                    //默认站撸怪！！！
                }
                Intent i = new Intent(getBaseContext(), MijiActivity.class);
                startActivity(i);
                //TODO
                SharedPreferences sharedpreferences = getSharedPreferences("tempjineng", Context.MODE_PRIVATE);
                try{
                    FileOutputStream fOut = openFileOutput("TempJN",Context.MODE_PRIVATE);
                    mymie.saveModel(sharedpreferences, fOut);
                    Log.d("Write to file", "Success");
                } catch (Exception e){
                    Log.e("File Error", "Error when try to open file to write.");
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(getBaseContext(), QixueActivity.class);
                    startActivity(i);
                }
            }
        });

        //CheckBox
        c11 = findViewById(R.id.bhgy1_1);
        c12 = findViewById(R.id.bhgy2_1);
        c13 = findViewById(R.id.bhgy2_2);
        c14 = findViewById(R.id.bhgy3_1);
        c15 = findViewById(R.id.bhgy3_2);
        c16 = findViewById(R.id.bhgy4_1);
        c17 = findViewById(R.id.bhgy5_1);
        c18 = findViewById(R.id.bhgy5_2);
        c11.setOnCheckedChangeListener(new BHGYCheckBoxListener());
        c12.setOnCheckedChangeListener(new BHGYCheckBoxListener());
        c13.setOnCheckedChangeListener(new BHGYCheckBoxListener());
        c14.setOnCheckedChangeListener(new BHGYCheckBoxListener());
        c15.setOnCheckedChangeListener(new BHGYCheckBoxListener());
        c16.setOnCheckedChangeListener(new BHGYCheckBoxListener());
        c17.setOnCheckedChangeListener(new BHGYCheckBoxListener());
        c18.setOnCheckedChangeListener(new BHGYCheckBoxListener());

        c21 = findViewById(R.id.wwwj1_1);
        c22 = findViewById(R.id.wwwj1_2);
        c23 = findViewById(R.id.wwwj2_1);
        c24 = findViewById(R.id.wwwj2_2);
        c25 = findViewById(R.id.wwwj3_1);
        c26 = findViewById(R.id.wwwj3_2);
        c27 = findViewById(R.id.wwwj4_1);
        c28 = findViewById(R.id.wwwj4_2);
        c29 = findViewById(R.id.wwwj5_1);
        c21.setOnCheckedChangeListener(new WWWJCheckBoxListener());
        c22.setOnCheckedChangeListener(new WWWJCheckBoxListener());
        c23.setOnCheckedChangeListener(new WWWJCheckBoxListener());
        c24.setOnCheckedChangeListener(new WWWJCheckBoxListener());
        c25.setOnCheckedChangeListener(new WWWJCheckBoxListener());
        c26.setOnCheckedChangeListener(new WWWJCheckBoxListener());
        c27.setOnCheckedChangeListener(new WWWJCheckBoxListener());
        c28.setOnCheckedChangeListener(new WWWJCheckBoxListener());
        c29.setOnCheckedChangeListener(new WWWJCheckBoxListener());

        c31 = findViewById(R.id.shty1_1);
        c32 = findViewById(R.id.shty2_1);
        c33 = findViewById(R.id.shty2_2);
        c34 = findViewById(R.id.shty3_1);
        c35 = findViewById(R.id.shty3_2);
        c36 = findViewById(R.id.shty4_1);
        c37 = findViewById(R.id.shty4_2);
        c38 = findViewById(R.id.shty5_1);
        c39 = findViewById(R.id.shty5_2);
        c31.setOnCheckedChangeListener(new SHTYCheckBoxListener());
        c32.setOnCheckedChangeListener(new SHTYCheckBoxListener());
        c33.setOnCheckedChangeListener(new SHTYCheckBoxListener());
        c34.setOnCheckedChangeListener(new SHTYCheckBoxListener());
        c35.setOnCheckedChangeListener(new SHTYCheckBoxListener());
        c36.setOnCheckedChangeListener(new SHTYCheckBoxListener());
        c37.setOnCheckedChangeListener(new SHTYCheckBoxListener());
        c38.setOnCheckedChangeListener(new SHTYCheckBoxListener());
        c39.setOnCheckedChangeListener(new SHTYCheckBoxListener());

        c41 = findViewById(R.id.rjhy1_1);
        c42 = findViewById(R.id.rjhy1_2);
        c43 = findViewById(R.id.rjhy2_1);
        c44 = findViewById(R.id.rjhy3_1);
        c45 = findViewById(R.id.rjhy3_2);
        c46 = findViewById(R.id.rjhy4_1);
        c47 = findViewById(R.id.rjhy4_2);
        c48 = findViewById(R.id.rjhy5_1);
        c41.setOnCheckedChangeListener(new RJHYCheckBoxListener());
        c42.setOnCheckedChangeListener(new RJHYCheckBoxListener());
        c43.setOnCheckedChangeListener(new RJHYCheckBoxListener());
        c44.setOnCheckedChangeListener(new RJHYCheckBoxListener());
        c45.setOnCheckedChangeListener(new RJHYCheckBoxListener());
        c46.setOnCheckedChangeListener(new RJHYCheckBoxListener());
        c47.setOnCheckedChangeListener(new RJHYCheckBoxListener());
        c48.setOnCheckedChangeListener(new RJHYCheckBoxListener());
    }

    class BHGYCheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                if(bhgyChecked < 5) {
                    bhgyChecked = bhgyChecked + 1;
                } else {
                    Toast.makeText(getApplicationContext(), "秘籍选择超过4本！", Toast.LENGTH_SHORT).show();
                }
            } else {
                bhgyChecked = bhgyChecked -1;
            }
        }
    }

    class WWWJCheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                if(wwwjChecked < 5) {
                    wwwjChecked = wwwjChecked + 1;
                } else {
                    Toast.makeText(getApplicationContext(), "秘籍选择超过4本！", Toast.LENGTH_SHORT).show();
                }
            } else {
                wwwjChecked = wwwjChecked -1;
            }
        }
    }

    class SHTYCheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                if(shtyChecked < 5) {
                    shtyChecked = shtyChecked + 1;
                } else {
                    Toast.makeText(getApplicationContext(), "秘籍选择超过4本！", Toast.LENGTH_SHORT).show();
                }
            } else {
                shtyChecked = shtyChecked -1;
            }
        }
    }

    class RJHYCheckBoxListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                if(rjhyChecked < 5) {
                    rjhyChecked = rjhyChecked + 1;
                } else {
                    Toast.makeText(getApplicationContext(), "秘籍选择超过4本！", Toast.LENGTH_SHORT).show();
                }
            } else {
                rjhyChecked = rjhyChecked -1;
            }
        }
    }
}
