package mcxia.dpssimulator_for_mie_jx3;

/**
 * Created by pipiyby on 11/13/17.
 * PersonalAttribute Model
 */

public class PersonalAttribute {
    private int attack;
    private int shenfa;
    private int huixin;
    private int huixiao;
    private int jiasu;
    private int mingzhong;
    private int wushuang;

    public PersonalAttribute(int attack, int shenfa, int huixin, int huixiao, int jiasu, int mingzhong, int wushuang){
        this.attack = attack;
        this.shenfa = shenfa;
        this.huixin = huixin;
        this.huixiao = huixiao;
        this.jiasu = jiasu;
        this.mingzhong = mingzhong;
        this.wushuang = wushuang;
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

    public int getJiasu(){
        return jiasu;
    }
    public void setJiasu(int jiasu){
        this.jiasu = jiasu;
    }

    public int getMingzhong(){
        return mingzhong;
    }
    public void setMingzhong(int mingzhong){
        this.mingzhong = mingzhong;
    }

    public int getWushuang(){
        return wushuang;
    }
    public void setWushuang(int wushuang){
        this.wushuang = wushuang;
    }
}
