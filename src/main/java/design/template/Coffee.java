package design.template;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/4
 */
public class Coffee extends BeveragesTemplate {
    @Override
    protected void brew() {
        System.out.println("用沸水冲汇咖啡");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入糖和牛奶");
    }
}
