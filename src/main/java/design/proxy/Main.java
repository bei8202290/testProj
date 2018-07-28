package design.proxy;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/3
 */
public class Main {
    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.say();
    }
}
