package design.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/9
 */
public class ConcreteObserver implements Observer {

    private String observerName;

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(Observable o, Object arg) {
        //推模式
        System.out.println(observerName+"收到了消息，目标推送过来的消息是：" + arg);
        //拉模式
        System.out.println(observerName+"收到了消息，主动到目标对象中拉取内容，拉取的内容是："
                + ((ConcreteWeatherSubject)o).getContent());
    }
}
