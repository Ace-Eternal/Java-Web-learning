package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties conf=new Properties();
    static{
//        类在加载时获取这个流当做资源加载
        InputStream inputStream=ConfigManager.class.getClassLoader().getResourceAsStream("config.properties");//getResourceAsStream用这个
        try{
            conf.load(inputStream);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getProp(String key){
        return conf.getProperty(key);
    }

}
