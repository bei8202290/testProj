package jvm.processor;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;

/**
 * @author ZLB
 * @Description:命名检查器
 * @date 2018/4/8
 */
public class NameChecker {

    private final Messager messager;

    NameCheckerScanner nameCheckerScanner = null;

    NameChecker(ProcessingEnvironment processingEnv){
        this.messager = processingEnv.getMessager();
        nameCheckerScanner = new NameCheckerScanner(messager);
    }

    /**
     * 对Java程序命名进行检查
     * 类或接口：符合驼式命名法，首字母大写。
     * 方法：符合驼式命名法，首字母小写。
     * 字段：
     *  类、实例变量：符合驼式命名法，首字母小写。
     *  常量：要求全部大写
     * @param element 当前语法树节点
     */
    public void checkNames(Element element){
        nameCheckerScanner.scan(element);
    }
}
