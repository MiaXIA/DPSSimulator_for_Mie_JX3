package mcxia.dpssimulator_for_mie_jx3.model;

/**
 * Created by mc.xia on 2017/11/14.
 */

public class Boss {
    private int level;
    private int mzrequire;
    private int wsrequire;
    private int fangyu;

    public Boss(int level, int mzrequire, int wsrequire, int fangyu){
        this.level = level;
        this.mzrequire = mzrequire;
        this.wsrequire = wsrequire;
        this.fangyu = fangyu;
    }

    public int getLevel(){
        return level;
    }
    public void setLevel(int level) { this.level = level; }

    public int getMzrequire(){
        return mzrequire;
    }
    public void setMzrequire(int mzrequire){
        this.mzrequire = mzrequire;
    }

    public int getWsrequire(){
        return wsrequire;
    }
    public void setWsrequire(int wsrequire){
        this.wsrequire = wsrequire;
    }

    public int getFangyu(){
        return fangyu;
    }
    public void setFangyu(int fangyu){
        this.fangyu = fangyu;
    }
}
