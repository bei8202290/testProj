package overwrite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZLB
 * @Description:
 * @date 2018/7/27
 */
public class Father {

    public List<Father> say(String name){
        System.out.println("i am "+name+",father!");
        return new ArrayList<Father>();
    }
}
