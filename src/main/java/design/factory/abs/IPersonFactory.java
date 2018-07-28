package design.factory.abs;

/**
 * @author ZLB
 * @Description:人物接口
 * @date 2018/4/11
 */
public interface IPersonFactory {

    //男孩接口
    public IBoy getBoy();

    //女孩接口
    public IGirl getGirl();

}
