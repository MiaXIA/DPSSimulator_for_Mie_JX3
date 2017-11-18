package mcxia.dpssimulator_for_mie_jx3.model;

/**
 * Created by pipiyby on 11/13/17.
 * PersonalAttribute Model
 */

public class PersonalAttribute {
    private int attack;
    private int shenfa;
    private double huixin;
    private double huixiao;
    private double jiasu;
    private double mingzhong;
    private double wushuang;
    private int pofang;

    public PersonalAttribute(int attack, int shenfa, double huixin, double huixiao, double jiasu, double mingzhong, double wushuang, int pofang){
        this.attack = attack;
        this.shenfa = shenfa;
        this.huixin = huixin;
        this.huixiao = huixiao;
        this.jiasu = jiasu;
        this.mingzhong = mingzhong;
        this.wushuang = wushuang;
        this.pofang = pofang;
    }

    public int getAttack(){
        return attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getShenfa(){
        return shenfa;
    }
    public void setShenfa(int shenfa){
        this.shenfa = shenfa;
    }

    public double getHuixin(){
        return huixin;
    }
    public void setHuixin(double huixin){
        this.huixin = huixin;
    }

    public double getHuixiao(){
        return huixiao;
    }
    public void setHuixiao(double huixiao){
        this.huixiao = huixiao;
    }

    public double getJiasu(){
        return jiasu;
    }
    public void setJiasu(double jiasu){
        this.jiasu = jiasu;
    }

    public double getMingzhong(){
        return mingzhong;
    }
    public void setMingzhong(double mingzhong){
        this.mingzhong = mingzhong;
    }

    public double getWushuang(){
        return wushuang;
    }
    public void setWushuang(double wushuang){
        this.wushuang = wushuang;
    }

    public int getPofang(){
        return pofang;
    }
    public void setPofang(int pofang){
        this.pofang = pofang;
    }
}
