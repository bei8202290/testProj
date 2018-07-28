package design.stragety;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/9
 */
public class Main {
    public static void main(String[] args) {
        Bird bird1 = new Swan();
        bird1.fly();
        Bird bird2 = new Chicken();
        bird2.fly();
    }
}
