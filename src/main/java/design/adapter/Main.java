package design.adapter;

/**
 * @author ZLB
 * @Description:适配器模式
 * @date 2018/4/3
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("111");
        TwoPlug twoPlug = new TwoPlug();
        IThreePlug threePlug = new TwoPlugAdapter(twoPlug);
        Notebook notebook = new Notebook(threePlug);
        notebook.charge();
        System.out.println("提效新内容啦！");
    }
}
