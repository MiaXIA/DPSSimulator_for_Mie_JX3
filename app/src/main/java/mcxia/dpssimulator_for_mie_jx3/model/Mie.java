package mcxia.dpssimulator_for_mie_jx3.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;

import java.io.InputStreamReader;
import java.util.Map;

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

    public Mie(){
    }

    public Mie(int attack, int shenfa, double huixin, double huixiao, double jiasu, double mingzhong, double wushuang, int pofang){
        MianBan = new PersonalAttribute(attack, shenfa, huixin, huixiao, jiasu, mingzhong, wushuang, pofang);
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
                sample.setHuixin(Double.parseDouble(tokens[9]));
                sample.setHuixiao(Double.parseDouble(tokens[10]));
                sample.setPercent(Integer.parseInt(tokens[11]));
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
    //Add SXC shanghai


    public double doSXC(){  //Sui Xing Chen
        setSXCTime(24.0);
        return 0.0;
    }

    public double doBH(){ //Ba Huang
        setBHcd(15.0);
        dou += 2;
        if(dou > 10){
            dou = 10;
        }
        //1 duan
        double att = (1 + MianBan.getPofang())*(100 + AttNum*1 + 2*WAttNum);
        //2 duan
        att += (1 + MianBan.getPofang())*(1200 + AttNum*0.2 + 0*WAttNum);
        //3 duan(奇穴：合光）
        if(qixue[8] == 1){
            att += (1 + MianBan.getPofang())*(25 + AttNum*0.25 + 0.5*WAttNum);
        }
        double huixinPro = Math.random();
        if(huixinPro < (MianBan.getHuixin() + JN.get("bhgy").getHuixin())/100){
            if(qixue[1] == 2){
                dou += 2;
                if(dou > 10){
                    dou = 10;
                }
            }
            return att*(MianBan.getHuixiao() + JN.get("bhgy").getHuixiao())/100;
        } else {
            return att;
        }
    }

    public double doRJ(){ //Ren Jian He Yi
        setSXCTime(0.0);
        double att = (1 + MianBan.getPofang())*(63 + AttNum*0.0996 + 0*WAttNum);
        double huixinPro = Math.random();
        if(huixinPro < (MianBan.getHuixin() + JN.get("rjhy").getHuixin())/100){
            return att*(MianBan.getHuixiao() + JN.get("rjhy").getHuixiao())/100;
        } else {
            return att;
        }
    }

    public double doWW(){   //Wu Wo Wu Jian
        double att = (1 + MianBan.getPofang())*(0 + AttNum*(0.9+0.05*dou) + 2*WAttNum);
        boolean fulldou = false;
        if(dou == 10){
            fulldou = true;
        }
        if(fulldou && qixue[2] == 1){
            double huidou = Math.random();
            if(huidou < 0.25){
                dou = 4;
            } else {
                dou = 0;
            }
        } else {
            dou = 0;
        }
        double huixinPro = Math.random();
        if(fulldou && qixue[3] == 2){
            if(huixinPro < (MianBan.getHuixin()/100 + JN.get("wwwj").getHuixin()/100 + 0.1)){
                if(qixue[1] == 2){
                    dou += 2;
                }
                return att*(MianBan.getHuixiao() + JN.get("wwwj").getHuixiao() + 20)/100;
            } else {
                return att;
            }
        } else {
            if (huixinPro < (MianBan.getHuixin() + JN.get("wwwj").getHuixin())/100){
                if (qixue[1] == 2) {
                    dou += 2;
                }
                return att * (MianBan.getHuixiao() + JN.get("wwwj").getHuixiao())/ 100;
            } else {
                return att;
            }
        }
    }

    public double doSH(){
        dou += 2;
        if(dou > 10){
            dou = 10;
        }
        int rand = (int)(Math.random()*13 + 123);
        if(qixue[0] == 1){

        }
        double att = (1 + MianBan.getPofang())*(rand + AttNum*0.825 + 1*WAttNum);
        double huixinPro = Math.random();
        if(huixinPro < (MianBan.getHuixin() + JN.get("shty").getHuixin())/100){
            if(qixue[1] == 2){
                dou += 2;
                if(dou > 10){
                    dou = 10;
                }
            }
            return att*(MianBan.getHuixiao() + JN.get("shty").getHuixiao())/100;
        } else {
            return att;
        }
    }

    public void generateDou(){
        dou += 1;
        if(dou > 10){
            dou = 10;
        }
    }

    //伤害=（1+破防)×[基础伤害+（攻击力×技能系数）+（武器伤害×武伤系数）]
    public double autoAtt(){
        double att =  (1 + MianBan.getPofang())*(AttNum*0.12 + 1.2*WAttNum);
        double huixinPro = Math.random();
        if(huixinPro < MianBan.getHuixin()/100){
            if(qixue[1] == 2){
                dou += 2;
                if(dou > 10){
                    dou = 10;
                }
            }
            return att*MianBan.getHuixiao()/100;
        } else {
            return att;
        }
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

    public void saveModel(SharedPreferences sharedpreferences, FileOutputStream fOut){
        //Save model in sharedpreferences.
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("attack", MianBan.getAttack());
        editor.putInt("shenfa", MianBan.getShenfa());
        editor.putString("huixin", Double.toString(MianBan.getHuixin()));
        editor.putString("huixiao", Double.toString(MianBan.getHuixiao()));
        editor.putString("jiasu", Double.toString(MianBan.getJiasu()));
        editor.putString("mingzhong", Double.toString(MianBan.getMingzhong()));
        editor.putString("wushuang", Double.toString(MianBan.getWushuang()));
        editor.putInt("attack", MianBan.getPofang());
        editor.putInt("Dou", dou);
        editor.putString("SXCTime", Double.toString(SXCTime));
        editor.putString("BHcd", Double.toString(BHcd));
        editor.putInt("DouLimit", douLimit);
        editor.putString("N", Double.toString(N));
        editor.putString("A", Double.toString(A));
        editor.putString("X", Double.toString(X));
        editor.putString("AttNum", Double.toString(AttNum));
        editor.putString("WAttNum", Double.toString(WAttNum));
        editor.putString("qixue", Arrays.toString(qixue));
        editor.commit();

        //Save model in CSV file.
        for(Map.Entry<String, JiNeng> J : JN.entrySet()){
            String s = "";
            s += J.getKey() + ",";
            JiNeng tempJiNeng = J.getValue();
            s += Integer.toString(tempJiNeng.getMana()) + ",";
            s += Integer.toString(tempJiNeng.getDou()) + ",";
            s += Double.toString(tempJiNeng.getCd()) + ",";
            s += Double.toString(tempJiNeng.getGcd()) + ",";
            s += Integer.toString(tempJiNeng.getLasttime()) + ",";
            s += Integer.toString(tempJiNeng.getReadtime()) + ",";
            s += Integer.toString(tempJiNeng.getBasicDamage()) + ",";
            s += Integer.toString(tempJiNeng.getBonusDamage()) + ",";
            s += Double.toString(tempJiNeng.getHuixin()) + ",";
            s += Double.toString(tempJiNeng.getHuixiao()) + ",";
            s += Integer.toString(tempJiNeng.getPercent()) + "\n";
            try{
                fOut.write(s.getBytes());
            } catch(Exception e){
                Log.e("File Error", "Error while writing to interal storage.");
            }
        }
        try{
            fOut.close();
        } catch (Exception e){
            Log.e("File Error", "Close file failed.");
        }
    }

    public void loadModel(SharedPreferences sharedpreferences, FileInputStream fin){
        //Load model from SharedPreferences
        MianBan = new PersonalAttribute(sharedpreferences.getInt("attack", 0), sharedpreferences.getInt("shenfa", 0),
                Double.parseDouble(sharedpreferences.getString("huixin", "0.0")), Double.parseDouble(sharedpreferences.getString("huixiao", "0.0")),
                Double.parseDouble(sharedpreferences.getString("jiasu", "0.0")), Double.parseDouble(sharedpreferences.getString("mingzhong", "0.0")),
                Double.parseDouble(sharedpreferences.getString("wushuang", "0.0")), sharedpreferences.getInt("pofang", 0));
        //Load model in CSV file.
        JN = new HashMap<String, JiNeng>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
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
                sample.setHuixin(Double.parseDouble(tokens[9]));
                sample.setHuixiao(Double.parseDouble(tokens[10]));
                sample.setPercent(Integer.parseInt(tokens[11]));
                JN.put(tokens[0], sample);
            }
        } catch (IOException e){
            Log.e("Parse Test", "CSV Test " + e.getMessage());
            e.printStackTrace();
        }
        dou = sharedpreferences.getInt("Dou", 10);
        SXCTime = Double.parseDouble(sharedpreferences.getString("SXCTime", "0.0"));
        BHcd = Double.parseDouble(sharedpreferences.getString("BHcd", "0.0"));
        douLimit = sharedpreferences.getInt("DouLimit", 0);
        N = Double.parseDouble(sharedpreferences.getString("N", "0.0"));
        A = Double.parseDouble(sharedpreferences.getString("A", "0.0"));
        X = Double.parseDouble(sharedpreferences.getString("X", "0.0"));
        AttNum = Double.parseDouble(sharedpreferences.getString("AttNum", "0.0"));
        WAttNum = Double.parseDouble(sharedpreferences.getString("WAttNum", "0.0"));
        String[] qixueStr = sharedpreferences.getString("qixue", "").split("]")[0].split("\\[")[1].split(",");
        qixue = new int[12];
        for(int i=0; i<12; i++){
            qixue[i] = Integer.parseInt(qixueStr[i]);
        }
    }
}
