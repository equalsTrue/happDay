package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserManagerProxy implements InvocationHandler{

    private Object target;

    public Object newProxyInteface(Object targetObject){
        this.target = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy start ");
        Object object = null;
        try {
            object = method.invoke(target,args);
            System.out.println("proxy success");
        }catch (Exception e){
            System.out.println("proxy error");
        }
        return object;
    }
}
