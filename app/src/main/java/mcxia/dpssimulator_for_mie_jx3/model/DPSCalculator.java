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
    private CountDownTimer SXCTimer;
    private CountDownTimer GCDTimer;
    private CountDownTimer BHCDTimer;
    private boolean loopctrl;


    public DPSCalculator(Mie mymie){
        MieModel = mymie;
        DPS = 0;
        targetDPS = 100000;
        cond = 1;
        loopctrl = false;
        setupTimers();
    }

    private void setupTimers(){
        SXCTimer = new CountDownTimer(1000*MieModel.getJN().get("sxc").getLasttime(), 1000) {
            @Override
            public void onTick(long l) {
                MieModel.setSXCTime(MieModel.getSXCTime() - 1.0);
            }

            @Override
            public void onFinish() {
                MieModel.setSXCTime(0.0);
            }
        };

        GCDTimer = new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                cond = 1;
            }
        };

        BHCDTimer = new CountDownTimer((long)(1000*MieModel.getJN().get("bhgy").getCd()), 1000) {
            @Override
            public void onTick(long l) {
                MieModel.setBHcd(MieModel.getBHcd() - 1.0);
            }

            @Override
            public void onFinish() {
                MieModel.setBHcd(0.0);
            }
        };
    }

    public void goSim(){
        //Loop for 5 min.
        CountDownTimer cdt = new CountDownTimer(300000, 1000) {
            @Override
            public void onTick(long l) {
                if(loopctrl == false) {
                    Log.d("Test Countdown 1", Long.toString(l));
                    loopDPS();
                    loopctrl = true;
                }
                MieModel.generateDou();
            }

            @Override
            public void onFinish() {
                loopctrl = false;
            }
        }.start();
    }


    private void loopDPS(){
        while(cond == 1){
            if(MieModel.getSXCTime() != 0.0){
                if(MieModel.getSXCTime() > 1.5){
                    if(MieModel.getDou() < MieModel.getDouLimit()){
                        if(MieModel.getBHcd() > 0){
                            DPS += MieModel.doSH();
                        } else {
                            //Calculate 8huang damage
                            //Set 8huang CD to 15
                            DPS += MieModel.doBH();
                            //BH Timer?????
                            BHCDTimer.start();
                        }
                    } else {
                        MieModel.doWW();
                    }
                } else {
                    DPS += MieModel.doRJ();
                    SXCTimer.cancel();
                }
            }
            else {
                //Do SXC.
                DPS += MieModel.doSXC();
                //Start SXC last time timer
                SXCTimer.start();
            }
            GCDTimer.start();
            while(cond == 0) {
            }
        }
    }

    public int getDPS(){
        return DPS;
    }
}
