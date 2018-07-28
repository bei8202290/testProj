package design.adapter;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/3
 */
public class Main {

    public static void main(String[] args) {
        TwoPlug twoPlug = new TwoPlug();
        IThreePlug threePlug = new TwoPlugAdapter(twoPlug);
        Notebook notebook = new Notebook(threePlug);
        notebook.charge();
    }
}
