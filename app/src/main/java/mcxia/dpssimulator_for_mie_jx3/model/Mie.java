package mcxia.dpssimulator_for_mie_jx3.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.*;

import java.io.InputStreamReader;

/**
 * Created by pipiyby on 11/17/17.
 * Character model
 */

public class Mie {
    static private HashMap<String, JiNeng> JN;
    static private List beans;
    static private PersonalAttribute MianBan;
    private int dou;

    public Mie(int attack, int shenfa, double huixin, double huixiao, double jiasu, double mingzhong, double wushuang, int pofang){
        MianBan = new PersonalAttribute( attack, shenfa, huixin, huixiao, jiasu, mingzhong, wushuang, pofang);
        JN = new HashMap<>();
        dou = 10;
    }

    public static void InitJiNeng(InputStream is){
        //Read data from CSV file to init JiNeng, using loop to put each JiNeng into HashMap JN
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        try{
            String line = reader.readLine();
            while((line = reader.readLine()) != null){
                //Split first
                String[] tokens = line.split(",");
                //Init JiNeng Class
                JiNeng sample = new JiNeng(tokens[0]);
                sample.setMana(Integer.parseInt(tokens[1]));
                sample.setDou(Integer.parseInt(tokens[2]));
                sample.setCd(Double.parseDouble(tokens[3]));
                sample.setGcd(Double.parseDouble(tokens[4]));
                sample.setLasttime(Integer.parseInt(tokens[5]));
                sample.setReadtime(Integer.parseInt(tokens[6]));
                sample.setBasicDamage(Integer.parseInt(tokens[7]));
                sample.setBonusDamage(Integer.parseInt(tokens[8]));
                JN.put(tokens[0], sample);
            }
//
        } catch (IOException e){
            Log.e("Parse Test", "CSV Test " + e.getMessage());
            e.printStackTrace();
        }
        Log.d("Parse Test", "2 " + JN.get("wwwj").getBonusDamage());
    }

    static public String showJN(){
        return beans.get(0).toString();
    }

    static public String showMianBan(){
        return MianBan.toString();
    }

    public HashMap<String, JiNeng> getJN(){
        return JN;
    }

    public int getDou(){
        return dou;
    }

}