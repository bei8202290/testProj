package design.Observer;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/9
 */
public class Main {
    public static void main(String[] args) {
        //1.创建目标
        ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
        //2.创建观察者
        ConcreteObserver girl = new ConcreteObserver();
        girl.setObserverName("小明的女朋友");
        ConcreteObserver mum = new ConcreteObserver();
        mum.setObserverName("小明的老妈");
        //3.注册观察者
        subject.addObserver(girl);
        subject.addObserver(mum);
        //目标更新天气情况
        subject.setContent("天气晴，气温28度");
    }
}
