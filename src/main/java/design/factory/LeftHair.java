package design.factory;

/**
 * @author ZLB
 * @Description:左偏分
 * @date 2018/4/11
 */
public class LeftHair implements IHair{

    @Override
    public void draw() {
        System.out.println("画出左偏分发型");
    }
}
