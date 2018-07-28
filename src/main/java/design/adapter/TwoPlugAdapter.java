package design.adapter;

/**
 * @author ZLB
 * @Description:二相转三相适配器
 * @date 2018/4/3
 */
public class TwoPlugAdapter implements IThreePlug {

    private TwoPlug plug;

    public TwoPlugAdapter(TwoPlug plug) {
        this.plug = plug;
    }

    @Override
    public void powerWithThree() {
        System.out.println("连接二相转三相适配器");
        plug.powerWithTwo();
    }
}
