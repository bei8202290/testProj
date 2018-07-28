package overwrite;

/**
 * @author ZLB
 * @Description:
 * @date 2018/7/27
 */
public class Main {

    public static void main(String[] args) {
        Father f = new Son();
        f.say("bei");
    }
}
