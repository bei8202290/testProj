package design.factory;

import java.util.Map;
import java.util.Properties;

/**
 * @author ZLB
 * @Description:发型工厂
 * @date 2018/4/11
 */
public class HairFactory {

    /**
     * 根据类型创建对象
     * @param key
     * @return
     */
    public IHair getHair(String key){
        if("left".equals(key)){
            return new LeftHair();
        }else if("right".equals(key)){
            return new RightHair();
        }
        return null;
    }

    /**
     * 根据类名创建对象
     * @param key
     * @return
     */
    public IHair getHariByClassName(String key){
        try {
            Map<String, String> map = PropertiesReader.getProperties("type.properties");
            String className = map.get(key);
            IHair hair = (IHair) Class.forName(className).newInstance();
            return hair;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
