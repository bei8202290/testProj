package design.stragety;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/9
 */
public class FlyNoWay implements FlyingStragety {
    @Override
    public void fly() {
        System.out.println("不会飞！");
    }
}
