package design.factory.abs;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/11
 */
public class MCFactory implements IPersonFactory {
    @Override
    public IBoy getBoy() {
        return new MCBoy();
    }

    @Override
    public IGirl getGirl() {
        return new MCGril();
    }
}
