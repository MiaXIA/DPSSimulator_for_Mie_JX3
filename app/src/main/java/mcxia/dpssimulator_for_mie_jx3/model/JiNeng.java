package mcxia.dpssimulator_for_mie_jx3.model;

import java.util.HashMap;

/**
 * Created by pipiyby on 11/13/17.
 * JiNeng Model
 */

public class JiNeng {

    private String name;
    private int mana;
    private int dou;
    private double cd;
    private double gcd;
    private int basicdamage;
    private int bonusweapondamage;
    private int lasttime;
    private int readtime;
    /*@CsvBindByName
    private int huixin;
    @CsvBindByName
    private int huixiao;*/
    private HashMap<String, Integer> MiJi;

    public JiNeng(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getCd(){
        return cd;
    }
    public void setCd(double cd){
        this.cd = cd;
    }

    public double getGcd(){
        return gcd;
    }
    public void setGcd(double gcd){
        this.gcd = gcd;
    }

    public int getMana(){
        return mana;
    }
    public void setMana(int mana){
        this.mana = mana;
    }

    public int getDou(){
        return dou;
    }
    public void setDou(int dou){
        this.dou = dou;
    }

    public int getBasicDamage(){
        return basicdamage;
    }
    public void setBasicDamage(int damage){
        this.basicdamage = damage;
    }

    public int getBonusDamage(){
        return bonusweapondamage;
    }
    public void setBonusDamage(int damage){
        this.bonusweapondamage = damage;
    }

    public int getLasttime(){
        return lasttime;
    }
    public void setLasttime(int lasttime){
        this.lasttime = lasttime;
    }

    public int getReadtime(){
        return readtime;
    }
    public void setReadtime(int readtime){
        this.readtime = readtime;
    }

    /*
    public int getHuixin(){
        return huixin;
    }
    public void setHuixin(int huixin){
        this.huixin = huixin;
    }

    public int getHuixiao(){
        return huixiao;
    }
    public void setHuixiao(int huixiao){
        this.huixiao = huixiao;
    }
    */

    public void addMiJi(String name, int effect){
        MiJi.put(name, effect);
    }
    public void delMiJi(String name){
        MiJi.remove(name);
    }
    public HashMap<String, Integer> getMiJi(){
        return MiJi;
    }
}
