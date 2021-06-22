package test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestLamda {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread,"mythread");
//        Thread thread1 = new Thread(myThread,"mythread2");
//        thread.start();
//        thread1.start();
        LocalDateTime date = LocalDateTime.now();
        System.out.println("date :" + date);
        lamdaT la = (a) -> { return a + " love lili";};
        String result = la.test("jack");
        System.out.println(la.test("jack"));
////        lamda la = new lamda1();
////        la.printName("test 1");
//
//       Thread thread =  new Thread(()->{
////            try {
////                Thread.sleep(2000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//           for (int i = 0; i < 50; i++) {
//               System.out.println(" thread begin i -- " + i );
//           }
//        });
//       thread.setName("thread main");
//
//        Thread thread1   =  new Thread(() ->{
//            for (int i = 1 ; i<100; i++){
//                lamda la =(a)->{
//                    System.out.println("lamda3 name = " +a);
//                };
//                la.printName("ff  begin i --"  + i);
//
////                la =(a)->{
////                    System.out.println("lamda4 name = " +a);
////                };
////                la.printName("gg");
//            }
//
//        });
//
//        thread1.setName("thread1");
//
//        thread.start();
//
//        thread1.start();
//
//        thread1.join();


//        thread.join();

    }

}

    class MyThread implements Runnable{

    static int count = 0;

    @Override
    public synchronized void  run() {
        for(int i = 1;i <= 10; i++){
            System.out.println(Thread.currentThread().getName() + " print count = " + count++);
        }

    }
}

class MyThread1 extends Thread{
    @Override
    public void run(){
        System.out.println("返回正在执行该代码的线程名称: " + Thread.currentThread().getName());
        System.out.println("当前线程对象的名称: " + this.getName());
    }
}

interface lamda {

    void printName(String name);
}

interface lamdaT{
   String test(String name);
}

class lamda1 implements lamda{

    @Override
    public void printName(String name) {
        System.out.println("lamda1 name = " +name);
    }
}

class lamda2 implements lamda{

    @Override
    public void printName(String name) {
        System.out.println("lamda2 name = " +name);
    }
}
