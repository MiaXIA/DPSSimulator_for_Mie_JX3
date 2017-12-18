package mcxia.dpssimulator_for_mie_jx3.model;

import android.os.CountDownTimer;
import android.util.Log;

/**
 * Created by pipiyby on 11/16/17.
 * DPS Calculator, doing calculating work, Model
 */

public class DPSCalculator {
    private Mie MieModel;
    private int targetDPS;
    private int DPS;
    private int DPSTime;
    private int cond;
    private double SXCTime = 24.0;
    private CountDownTimer SXCTimer;


    public DPSCalculator(Mie mymie){
        MieModel = mymie;
        DPS = 0;
        targetDPS = 100000;
        cond = 1;
        setupTimers(mymie);
    }

    private void setupTimers(Mie mymie){
        SXCTimer = new CountDownTimer(mymie.getJN().get("sxc").getLasttime(), 1000) {
            @Override
            public void onTick(long l) {
                SXCTime -= 1.0;
            }

            @Override
            public void onFinish() {
                SXCTime = 0.0;
            }
        };
    }

    public void goSim(){
        //Loop for 5 min.
        CountDownTimer cdt = new CountDownTimer(300000, 1000) {
            @Override
            public void onTick(long l) {
                loopDPS();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

//    public void loopTest(){
//        CountDownTimer cdt = new CountDownTimer(10000, 1000) {
//            @Override
//            public void onTick(long l) {
//                Log.d("Timer", "Time" + Math.ceil(l/1000));
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
//
//        CountDownTimer cdt1 = new CountDownTimer(15000, 1000) {
//            @Override
//            public void onTick(long l) {
//                Log.d("Timer", "Time" + Math.ceil(l/1000));
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
//    }

    private void loopDPS(){
        while(cond == 1){
            if(SXCTime != 0.0){

            }
            else {
                SXCTime = 24.0;
                SXCTimer.start();
            }
        }
    }

    public int getDPS(){
        return DPS;
    }
}
