package design.factory.abs;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/11
 */
public class Main {

    public static void main(String[] args) {
        IPersonFactory factory = new MCFactory();
        IGirl girl = factory.getGirl();
        girl.drawGirl();

        IPersonFactory factory2 = new HNFactory();
        IBoy boy = factory2.getBoy();
        boy.drawBoy();
    }

}
