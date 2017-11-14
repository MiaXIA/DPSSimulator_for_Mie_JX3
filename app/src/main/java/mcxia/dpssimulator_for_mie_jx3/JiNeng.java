package mcxia.dpssimulator_for_mie_jx3;

import java.util.HashMap;

/**
 * Created by pipiyby on 11/13/17.
 * JiNeng Model
 */

public class JiNeng {
    private String name;
    private int cd;
    private int damage;
    //private int huixin;
    //private int huixiao;
    private HashMap<String, Integer> MiJi;

    public JiNeng(String name, int cd, int damage, int huixin, int huixiao){
        this.name = name;
        this.cd = cd;
        this.damage = damage;
        //this.huixin = huixin;
        //this.huixiao = huixiao;
    }

    public String getName(){
        return name;
    }

    public int getCd(){
        return cd;
    }
    public void setCd(int cd){
        this.cd = cd;
    }

    public int getDamage(){
        return damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
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
