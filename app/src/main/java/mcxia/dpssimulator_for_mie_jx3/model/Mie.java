package mcxia.dpssimulator_for_mie_jx3.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import java.io.InputStreamReader;

/**
 * Created by pipiyby on 11/17/17.
 * Character model
 */

public class Mie {
    private HashMap<String, JiNeng> JN;
    static private List beans;
    static private PersonalAttribute MianBan;
    private int dou;

    public Mie(int attack, int shenfa, double huixin, double huixiao, double jiasu, double mingzhong, double wushuang, int pofang){
        MianBan = new PersonalAttribute( attack, shenfa, huixin, huixiao, jiasu, mingzhong, wushuang, pofang);
        //InitJiNeng();
        dou = 10;
    }

    public static void InitJiNeng(Context mycontext){
        //Read data from CSV file to init JiNeng, using loop to put each JiNeng into HashMap JN

        try{
            AssetManager am = mycontext.getAssets();
            InputStream is = am.open("jineng.csv");
            CSVReader csvReader = new CSVReader(new InputStreamReader(is));
            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
            mappingStrategy.setType(JiNeng.class);
            String[] columns = new String[]{"name","mana","dou","cd","gcd","lasttime","readtime","basicdamage","bonusweapondamage"};
            mappingStrategy.setColumnMapping(columns);
            CsvToBean ctb = new CsvToBean();
            beans = ctb.parse(mappingStrategy,csvReader);
            //beans = new CsvToBeanBuilder(new InputStreamReader(is)).withType(JiNeng.class).build().parse();

        } catch (IOException e){
            Log.e("Parse Test", "CSV Test " + e.getMessage());
        }
    }

    static public String showJN(){
        return beans.get(0).toString();
    }

    static public String showMianBan(){
        return MianBan.toString();
    }

}
