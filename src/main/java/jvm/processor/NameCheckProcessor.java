package jvm.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author ZLB
 * @Description:命名检查注解处理器
 * @date 2018/4/8
 */
//用"*"表示支持所有Annotations
@SupportedAnnotationTypes("*")
//只支持JDK 1.8的Java代码
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class NameCheckProcessor extends AbstractProcessor{

    private NameChecker nameChecker;

    /**
     * 初始化名称检查插件
     * @param processingEnv
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.nameChecker = new NameChecker(processingEnv);
    }

    /**
     * 对输入的语法树的各个节点进行名称检查
     * @param annotations 处理器所要处理的注解集合
     * @param roundEnv 用来获取当前Round中的语法树节点
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(!roundEnv.processingOver()){
            for(Element element : roundEnv.getRootElements()){
                this.nameChecker.checkNames(element);
            }
        }
        return false;
    }
}
