package design.template;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/4
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("开始制作咖啡");
        Coffee coffee = new Coffee();
        coffee.make();
        System.out.println("咖啡好了");
        System.out.println("\n********************************");
        System.out.println("开始制作茶");
        Tea tea = new Tea();
        tea.make();
        System.out.println("茶泡好了");

    }
}
