package design.template;

/**
 * @author ZLB
 * @Description:饮料模板基类
 * @date 2018/4/4
 */
public abstract class BeveragesTemplate {

    /**
     * 制作饮料模板算法
     */
    public final void make(){
        //1.烧水
        boilWater();
        //2.泡制饮料
        brew();
        //3.将饮料倒入杯中
        pourinCup();
        //4.加入调味料
        if(isAdd()){
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("烧水");
    }

    protected abstract void brew();

    private void pourinCup() {
        System.out.println("将饮料倒入杯中");
    }

    protected abstract void addCondiments();

    /**
     * Hook,钩子函数，提供一个默认或空的实现
     * 具体子类可以自行决定是否挂钩以及如何挂钩
     * 询问用户是否加入调料
     * @return
     */
    protected boolean isAdd(){
        return true;
    }
}
