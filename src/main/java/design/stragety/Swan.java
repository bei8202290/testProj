package design.stragety;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/9
 */
public class Swan extends Bird {

    public Swan(){
        super();
        this.flyingStragety = new FlyWithWin();
    }

    @Override
    public void fly() {
        flyingStragety.fly();;
    }
}
