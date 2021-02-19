package test.token;

public class AccountSync implements Runnable {

    static AccountSync instance=new AccountSync();
    static int i=0;
    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized(instance){
            for(int j=0;j<1000;j++){
                i++;
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
//        Thread t1=new Thread(instance);
//        Thread t2=new Thread(instance);
//        t1.start();
//        System.out.println("t1 start");
//        t2.start();
//        System.out.println("t2 start");
//        t1.join();
//        System.out.println("t1 join");
//        t2.join();
//        System.out.println("t2 join");
//        System.out.println("total i =" + i);
        String a = new String("a");
        String b = "a";
        String c = a.intern();
        String d = new String("a");
        System.out.println(b==c);
    }
}
