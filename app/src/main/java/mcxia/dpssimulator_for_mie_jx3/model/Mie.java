package mcxia.dpssimulator_for_mie_jx3.model;

import java.util.HashMap;

/**
 * Created by pipiyby on 11/17/17.
 * Character model
 */

public class Mie {
    private HashMap<String, JiNeng> JN;
    private PersonalAttribute MianBan;
    private int dou;

    public Mie(int attack, int shenfa, double huixin, double huixiao, double jiasu, double mingzhong, double wushuang, int pofang){
        MianBan = new PersonalAttribute( attack, shenfa, huixin, huixiao, jiasu, mingzhong, wushuang, pofang);
        InitJiNeng();
        dou = 10;
    }

    private void InitJiNeng(){
        //Read data from CSV file to init JiNeng, using loop to put each JiNeng into HashMap JN
    }

}
