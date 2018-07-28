package design.template;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/4
 */
public class Tea extends BeveragesTemplate {
    @Override
    protected void brew() {
        System.out.println("用80度开水冲泡茶叶");
    }

    @Override
    protected void addCondiments() {
        System.out.println("放入柠檬");
    }

    @Override
    protected boolean isAdd() {
        return false;
    }
}
