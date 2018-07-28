package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZLB
 * @Description:
 * @date 2018/4/3
 */
public class DynamicProxy implements InvocationHandler {

    public Object target;

    public Object bind(Object target){
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Welcome to JAVA!");
        return method.invoke(target,args);
    }
}
