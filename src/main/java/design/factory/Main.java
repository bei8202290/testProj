package design.factory;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/11
 */
public class Main {

    public static void main(String[] args) {
        HairFactory factory = new HairFactory();
        IHair hair = factory.getHair("left");
        HairFactory factory2 = new HairFactory();
        IHair hair2 = factory2.getHariByClassName("right");
        hair.draw();
        hair2.draw();
    }

}
