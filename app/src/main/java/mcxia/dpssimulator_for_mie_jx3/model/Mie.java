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
    static private PersonalAttribute MianBan;
    private int dou;
    static private double SXCTime;
    static private double BHcd;
    private int douLimit;
    private double N, A, X;
    private double AttNum;
    private double WAttNum;
    private int[] qixue;

    public Mie(int attack, int shenfa, double huixin, double huixiao, double jiasu, double mingzhong, double wushuang, int pofang){
        MianBan = new PersonalAttribute( attack, shenfa, huixin, huixiao, jiasu, mingzhong, wushuang, pofang);
        JN = new HashMap<>();
        dou = 10;
        qixue = new int[10];
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
                sample.setHuixin(0.0);
                sample.setHuixiao(0.0);
                JN.put(tokens[0], sample);
            }
        } catch (IOException e){
            Log.e("Parse Test", "CSV Test " + e.getMessage());
            e.printStackTrace();
        }
        //Log.d("Parse Test", "2 " + JN.get("wwwj").getBonusDamage());
        SXCTime = JN.get("sxc").getLasttime();
        BHcd = JN.get("bhgy").getCd();
    }

    public void CalAttNum(){
        AttNum = N*(1+X/100)+A;
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
    public double getSXCTime(){
        return SXCTime;
    }
    public double getBHcd(){
        return BHcd;
    }

    public void setSXCTime(double SXCTime){
        this.SXCTime = SXCTime;
    }

    public void setBHcd(double BHcd){
        this.BHcd = BHcd;
    }

    //伤害=（1+破防)×[基础伤害+（攻击力×技能系数）+（武器伤害×武伤系数）]

    public double doSXC(){  //Sui Xing Chen
        setSXCTime(24.0);
        dou += 2;
        if(dou > 10){
            dou = 10;
        }
        return 0.0;
    }

    public double doBH(){ //Ba Huang
        setBHcd(15.0);
        //Dou calculation(TBD)
        return 0.0;
    }

    public double doRJ(){ //Ren Jian He Yi
        setSXCTime(0.0);
        double N = MianBan.getAttack() - MianBan.getShenfa()*1.45;
        double A = MianBan.getShenfa()*1.45;
        double X = 0.0; //(TBD)
        //Dou calculation(TBD)
        return (N*(1+X/100)+A);
    }

    public double doWW(){   //Wu Wo Wu Jian
        dou = 0;
        return 0.0;
    }

    public double doSH(){
        dou += 2;
        if(dou > 10){
            dou = 10;
        }
        int rand = (int)(Math.random()*13 + 123);
        if(qixue[0] == 1){

        }
        return (1 + MianBan.getPofang())*(rand + AttNum*0.825 + 1*WAttNum);
    }

    public void generateDou(){
        dou += 1;
        if(dou > 10){
            dou = 10;
        }
    }

    //伤害=（1+破防)×[基础伤害+（攻击力×技能系数）+（武器伤害×武伤系数）]
    public double autoAtt(){
        return (1 + MianBan.getPofang())*(AttNum*0.12 + 1.2*WAttNum);
    }

    public double getGcd(){
        return MianBan.getGongCD();
    }

    public double getAutocd(){
        return MianBan.getACD();
    }

    public int getDouLimit(){
        return douLimit;
    }

    public void setQixue(int index, int choice){
        qixue[index] = choice;
    }
}
