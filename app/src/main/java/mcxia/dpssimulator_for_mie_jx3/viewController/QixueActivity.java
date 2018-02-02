package mcxia.dpssimulator_for_mie_jx3.viewController;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import java.io.InputStream;

import mcxia.dpssimulator_for_mie_jx3.R;
import mcxia.dpssimulator_for_mie_jx3.model.Mie;

/**
 * Created by pipiyby on 1/10/18.
 */

public class QixueActivity extends Activity {
    private RadioGroup qx1RadioGroup,qx2RadioGroup,qx3RadioGroup,qx4RadioGroup,qx5RadioGroup,qx6RadioGroup;
    private RadioGroup qx7RadioGroup,qx8RadioGroup,qx9RadioGroup,qx10RadioGroup,qx11RadioGroup,qx12RadioGroup;
    private Mie mymie;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qixue);
        mymie = new Mie();
        mymie.loadModel();
        initView();

        Button gotoMiji = findViewById(R.id.gotomiji_button);
        gotoMiji.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mymie.saveModel();
                Intent i = new Intent(getBaseContext(), MijiActivity.class);
                startActivity(i);
            }
        });
    }

    private void initView() {
        /** RadioGroup and RadioButton **/
        qx1RadioGroup = findViewById(R.id.qx1);
        qx1RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx1_1) {  //挫锐
                    mymie.setQixue(0, 1);
                    mymie.getJN().get("shty").addHuixiao(10.0);
                    mymie.getJN().get("shty").addHuixin(10.0);
                } else if (checkedId == R.id.qx1_2) {  //心固
                    mymie.setQixue(0, 2);
                    mymie.getJN().get("shty").addPercent(10);
                } else if (checkedId == R.id.qx1_3) {  //不善
                    //???????????????????????????????????
                }
            }
        });

        qx2RadioGroup = findViewById(R.id.qx2);
        qx2RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx2_1) {  //同根
                    mymie.setQixue(1, 1);
                    mymie.getJN().get("wwwj").addPercent(10);
                    //mymie.getJN().get("wjgz").addPercent(10);
                    //mymie.getJN().get("wjgz").setCd(mymie.getJN().get("wjgz").getCd() - 3.0);
                } else if (checkedId == R.id.qx2_2) {  //深埋
                    mymie.setQixue(1, 2);
                } else if (checkedId == R.id.qx2_3) {  //吐故纳新
                    //?????????????????????????????????????
                }
            }
        });

        qx3RadioGroup = findViewById(R.id.qx3);
        qx3RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx3_1) {  //昆吾:消耗10气点施展无我有25%几率马上回复4气点，8秒CD
                    mymie.setQixue(2, 1);
                } else if (checkedId == R.id.qx3_2) {  //白虹:产品胎说不算它
                    mymie.setQixue(2, 2);
                } else if (checkedId == R.id.qx3_3) {  //数穷
                } else if (checkedId == R.id.qx3_4) { //化三清
                }
            }
        });

        qx4RadioGroup = findViewById(R.id.qx4);
        qx4RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx4_1) {  //风逝
                } else if (checkedId == R.id.qx4_2) {  //无意
                    mymie.setQixue(3, 2);
                } else if (checkedId == R.id.qx4_3) {  //元剑
                    mymie.setQixue(3, 3);
                    mymie.getJN().get("bhgy").addHuixin(10.0);
                    mymie.getJN().get("bhgy").addHuixiao(20.0);
                } else if (checkedId == R.id.qx4_4) {  //剑飞惊天
                }
            }
        });

        qx5RadioGroup = findViewById(R.id.qx5);
        qx5RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx5_1) {  //独笑

                } else if (checkedId == R.id.qx5_2) {  //心转:每有2个气点，三环伤害+5%
                    mymie.setQixue(4, 2);
                } else if (checkedId == R.id.qx5_3) {  //狂歌

                } else if (checkedId == R.id.qx5_4) {  //合真

                }
            }
        });

        qx6RadioGroup = findViewById(R.id.qx6);
        qx6RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx6_1) {  //解牛

                } else if (checkedId == R.id.qx6_2) {  //解纷

                } else if (checkedId == R.id.qx6_3) {  //叠刃:无我会心后，+1层叠刃
                    mymie.setQixue(5, 3);
                } else if (checkedId == R.id.qx6_4) {  //开兑

                }
            }
        });

        qx7RadioGroup = findViewById(R.id.qx7);
        qx7RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx7_1) {  //切玉:施展八荒后，若目标血量<40%，则立即引爆叠刃
                    mymie.setQixue(6, 1);
                } else if (checkedId == R.id.qx7_2) {  //雾外江山:读条施展气场后，8秒内下一个气场瞬发；施展所有气场立即额外获得2个气点
                    mymie.setQixue(6, 2);
                } else if (checkedId == R.id.qx7_3) {  //云凌
                    mymie.setQixue(6, 3);
                } else if (checkedId == R.id.qx7_4) {  //凌太虚

                }
            }
        });

        qx8RadioGroup = findViewById(R.id.qx8);
        qx8RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx8_1) {  //负阴:碎星辰对自身增益提高100%
                    mymie.setQixue(7, 1);
                } else if (checkedId == R.id.qx8_2) {  //无我

                } else if (checkedId == R.id.qx8_3) {  //匣中

                } else if (checkedId == R.id.qx8_4) {  //惊世

                }
            }
        });

        qx9RadioGroup = findViewById(R.id.qx9);
        qx9RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx9_1) {  //和光:八荒命中带有叠刃的目标后，额外造成一段伤害，数值为八荒一段伤害的25%
                    mymie.setQixue(8, 1);
                } else if (checkedId == R.id.qx9_2) {  //实腹

                } else if (checkedId == R.id.qx9_3) {  //故长

                } else if (checkedId == R.id.qx9_4) {  //随物

                }
            }
        });

        qx10RadioGroup = findViewById(R.id.qx10);
        qx10RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx10_1) {  //期声:位于增益气场中时增加10%基础攻击力
                    mymie.setQixue(9, 1);
                } else if (checkedId == R.id.qx10_2) {  //物我两忘

                } else if (checkedId == R.id.qx10_3) {  //御风

                } else if (checkedId == R.id.qx10_4) {  //心剑两望

                }
            }
        });

        qx11RadioGroup = findViewById(R.id.qx11);
        qx11RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx11_1) {  //无欲:每消耗2个气点施展无我无剑，八荒CD-1S
                    mymie.setQixue(10, 1);
                } else if (checkedId == R.id.qx11_2) {  //凶年

                } else if (checkedId == R.id.qx11_3) {  //静笃

                } else if (checkedId == R.id.qx11_4) {  //虚极

                }
            }
        });

        qx12RadioGroup = findViewById(R.id.qx12);
        qx12RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //TODO
                if (checkedId == R.id.qx12_1) {  //若水

                } else if (checkedId == R.id.qx12_2) {  //固本

                } else if (checkedId == R.id.qx12_3) {  //玄门:人剑合一每引爆一个气场，叠加一层玄门buff：会心+5%，破防+20%，最多叠加三层；叠加时刷新玄门时间
                    mymie.setQixue(11, 3);
                } else if (checkedId == R.id.qx12_4) {  //行天道

                }
            }
        });
    }


}
