package test;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

@SuppressWarnings("ALL")
public class TestFo{

    public static void main(String[] args) throws Exception {
        Food apple = new Apple("construct test","111");
        apple.printId("123");
        Class<?> cls = Class.forName("test.Apple");
        Class<?> ft = cls.getSuperclass();
        Method method = ft.getDeclaredMethod("printName",String.class,int.class);
        method.setAccessible(true);
        Object target = ft.newInstance();
        method.invoke(target,"food",123);
        Thread t1 = new Thread( () -> {

        });
        t1.start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("test 1");
            }
        };
        executorService.execute(() -> System.out.println(""));

    }
}
