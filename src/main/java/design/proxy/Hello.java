package design.proxy;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/3
 */
public class Hello implements IHello {
    @Override
    public void say() {
        System.out.println("Hello world!");
    }
}
