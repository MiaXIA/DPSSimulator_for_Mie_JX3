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

    public double getGongCD(){
        if(jiasu>=0 && jiasu<0.11){
            return 1.5;
        } else if(jiasu>=0.11 && jiasu<4.41){
            return 1.44;
        } else if(jiasu>=4.41 && jiasu<9.2){
            return 1.38;
        } else if(jiasu>=9.2 && jiasu<14.37){
            return 1.31;
        } else if(jiasu>=14.37 && jiasu<20.03){
            return 1.25;
        } else if(jiasu>=20.03){
            return 1.19;
        }
        return 1.5;
    }

    public double getACD(){
        if(jiasu>=0 && jiasu<0.11){
            return 1.31;
        } else if(jiasu>=0.11 && jiasu<5.09){
            return 1.25;
        } else if(jiasu>=5.09 && jiasu<10.56){
            return 1.19;
        } else if(jiasu>=10.56 && jiasu<16.70){
            return 1.13;
        } else if(jiasu>=16.70 && jiasu<23.55){
            return 1.06;
        } else if(jiasu>=23.55){
            return 1.0;
        }
        return 1.31;
    }

    public String toString(){
        return "Attack: " + attack + ",\nShenFa: " + shenfa + ",\nHuiXin: " + huixin + ",\nHuiXiao: " + huixiao
                + ",\nJiaSu: " + jiasu + ",\nMingZhong: " + mingzhong + ",\nWuShuang: " + wushuang + ",\nPoFang: " + pofang;
    }
}
