package test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibManagerProxy implements MethodInterceptor {

    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib proxy start");
        Object invoke = method.invoke(target,objects);
//        Object invoke = methodProxy.invokeSuper(target,objects);
        System.out.println("Cglib proxy finish");
        return invoke;
    }


    public Object getCglibProxy(Object targetObject){
        this.target = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        Object result = enhancer.create();
        return result;
    }

    public static void main(String[] args){
        CglibManagerProxy cglib = new CglibManagerProxy();
        UserManager userManager = (UserManager) cglib.getCglibProxy(new UserManagerImpl());
        userManager.addUser("cglib test");
    }
}
