package overwrite;

import java.util.ArrayList;

/**
 * @author ZLB
 * @Description:
 * @date 2018/7/27
 */
public class Son extends Father{

    public ArrayList say(String name){
        System.out.println("i am "+name+",son!");
        return new ArrayList<Object>();
    }
}
