package jvm.processor;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.annotation.processing.Messager;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;

/**
 * @author ZLB
 * @Description: 名称检查器实现类，继承了JDK 1.8中提供的ElementScanner8
 * @date 2018/4/8
 */
public class NameCheckerScanner extends ElementScanner8<Void, Void>{

    private Messager messager;

    public NameCheckerScanner(Messager messager){
        this.messager = messager;
    }

    /**
     * 检查Java类
     * @param e
     * @param p
     * @return
     */
    @Override
    public Void visitType(TypeElement e, Void p){
        scan(e.getTypeParameters(),p);
        checkCamelCase(e, true);
        return super.visitType(e, p);
    }

    @Override
    public Void visitExecutable(ExecutableElement e, Void aVoid) {
        if(e.getKind() == ElementKind.METHOD){
            Name name = e.getSimpleName();
            if(name.contentEquals(e.getEnclosingElement().getSimpleName())){
                messager.printMessage(Diagnostic.Kind.WARNING, "一个普通方法" + name + "不应该与类名重复，避免与构造函数产生混淆");
            }else{
                checkCamelCase(e, false);
            }
        }
        return super.visitExecutable(e, aVoid);
    }

    @Override
    public Void visitVariable(VariableElement e, Void aVoid) {
        //如果这个Variable是枚举或常量，则按大写命名检查，否则按照驼式命名法规则检查
        if(e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null){
            checkAllCaps(e);
        }else{
            checkCamelCase(e, false);
        }
        return null;
    }

    /*private boolean heuristicallyConstant(VariableElement e){
        if(e.getEnclosingElement().getKind() == ElementKind.INTERFACE){
            return true;
        }else if(e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(PUBLIC, STATIC, FINAL))){
            return true;
        }else{
            return false;
        }

    }*/

    /**
     * 检查输入的Element是否符合驼式命名法，如果不符合，则输出警告信息
     * @param e
     * @param initialCaps
     */
    private void checkCamelCase(Element e, boolean initialCaps){
        String name = e.getSimpleName().toString();
        boolean previousUpper = false;
        boolean conventional = true;
        int firstCodePoint = name.codePointAt(0);
        if(Character.isUpperCase(firstCodePoint)){
            previousUpper = true;
            if(!initialCaps){
                messager.printMessage(Diagnostic.Kind.WARNING,"名称" + name + "应当以小写字母开头",e);
                return;
            }
        }else if(Character.isLowerCase(firstCodePoint)){
            if(initialCaps){
                messager.printMessage(Diagnostic.Kind.WARNING,"名称" + name + "应当以大写字母开头",e);
                return;
            }
        }else{
            conventional = false;
        }

        if(conventional){
            int cp = firstCodePoint;
            for(int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)){
                cp = name.codePointAt(i);
                if(Character.isUpperCase(cp)){
                    if(previousUpper){
                        conventional = false;
                        break;
                    }
                    previousUpper = true;
                }else{
                    previousUpper = false;
                }
            }
        }

        if(!conventional){
            messager.printMessage(Diagnostic.Kind.WARNING,"名称" + name + "应当符合驼式命名法",e);
        }
    }

    /**
     * 大写命名检查，要求第一个字母必须是大写的英文字母，其余部分可以是下划线或大写字母
     * @param e
     */
    private void checkAllCaps(Element e){
        String name = e.getSimpleName().toString();
        boolean conventional = true;
        int firstCodePoint = name.codePointAt(0);

        if(!Character.isUpperCase(firstCodePoint)){
            conventional = false;
        }else{
            boolean previousUnderscore = false;
            int cp = firstCodePoint;
            for(int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)){
                cp = name.codePointAt(i);
                if(cp == (int) '_'){
                    if(previousUnderscore){
                        conventional = false;
                        break;
                    }
                    previousUnderscore = true;
                }else{
                    previousUnderscore = false;
                    if(!Character.isUpperCase(cp) && !Character.isDigit(cp)){
                        conventional = false;
                        break;
                    }
                }
            }
        }
        if(!conventional){
            messager.printMessage(Diagnostic.Kind.WARNING,"常量" + name + "应当全部以大写字母或下划线命名，且以字母开头",e);
        }
    }
}
