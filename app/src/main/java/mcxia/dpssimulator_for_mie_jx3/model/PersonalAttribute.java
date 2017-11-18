package mcxia.dpssimulator_for_mie_jx3;

/**
 * Created by pipiyby on 11/13/17.
 * PersonalAttribute Model
 */

public class PersonalAttribute {
    private double attack;
    private double shenfa;
    private double huixin;
    private double huixiao;
    private double jiasu;
    private double mingzhong;
    private double wushuang;

    public PersonalAttribute(double attack, double shenfa, double huixin, double huixiao, double jiasu, double mingzhong, double wushuang){
        this.attack = attack;
        this.shenfa = shenfa;
        this.huixin = huixin;
        this.huixiao = huixiao;
        this.jiasu = jiasu;
        this.mingzhong = mingzhong;
        this.wushuang = wushuang;
    }

    public double getAttack(){
        return attack;
    }
    public void setAttack(double attack){
        this.attack = attack;
    }

    public double getShenfa(){
        return shenfa;
    }
    public void setShenfa(double shenfa){
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
}
