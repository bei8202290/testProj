package design.Observer;

import java.util.Observable;

/**
 * @author ZLB
 * @Description:天气目标具体实现类，继承Java目标接口
 * @date 2018/4/9
 */
public class ConcreteWeatherSubject extends Observable {
    //天气内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        //通知所有的观察者
        //1.在用Java提供的Observer模式时，此句不可少
        this.setChanged();
        //2.主动通知（拉模式）
       /* this.notifyObservers();*/
        //推模式
        this.notifyObservers(content);
    }
}
