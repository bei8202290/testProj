package design.adapter;

/**
 * @author ZLB
 * @Description:笔记本电脑
 * @date 2018/4/3
 */
public class Notebook {

    /* 三相插口 */
    public IThreePlug plug;

    public Notebook(IThreePlug plug) {
        this.plug = plug;
    }

    /**
     * 使用插座充电
     */
    public void charge(){
        plug.powerWithThree();
    }
}
