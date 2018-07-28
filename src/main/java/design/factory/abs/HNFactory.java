package design.factory.abs;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/11
 */
public class HNFactory implements IPersonFactory {
    @Override
    public IBoy getBoy() {
        return new HNBoy();
    }

    @Override
    public IGirl getGirl() {
        return new HNGirl();
    }
}
