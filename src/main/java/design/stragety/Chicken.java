package design.stragety;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/9
 */
public class Chicken extends Bird {

    public Chicken(){
        super();
        this.flyingStragety = new FlyNoWay();
    }

    @Override
    public void fly() {
        this.flyingStragety.fly();
    }
}
