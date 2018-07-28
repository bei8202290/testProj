package design.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author ZLB
 * @Description:属性文件读取类
 * @date 2018/4/11
 */
public class PropertiesReader {

    public static Map<String,String> getProperties(String fileName){
        Properties props = new Properties();
        Map<String, String> map = new HashMap<String, String>();
        try {
            String path = fileName;
            InputStream in = PropertiesReader.class.getClassLoader().getResourceAsStream(path);
            props.load(in);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()){
                String key = (String) en.nextElement();
                String value = (String) props.getProperty(key);
                System.out.println("value="+value);
                map.put(key, value);
            }
            return map;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
