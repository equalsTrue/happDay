package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestBank {

    public static void main(String[] args){
        Account account = new Account("公户",1000);
        PayMoney payMoney1 = new PayMoney(account,"A",500);
        PayMoney payMoney2 = new PayMoney(account,"B",800);
        Thread thread = new Thread(payMoney1,"线程A");
        Thread thread1 = new Thread(payMoney2,"线程B");
        thread.start();
        thread1.start();
    }

}


class Account {

    public Account(String name,int money){
        this.name = name;

        this.money = money;
    }

    String name;

    int money;
}


class PayMoney implements Runnable{

    Account account;

    boolean flag = true;

    String username;

    int payCount;

    private final ReentrantLock lock = new ReentrantLock();

    public PayMoney(Account account,String username,int payCount){
        this.account = account;
        this.username = username;
        this.payCount = payCount;
    }

    @Override
    public void run() {
        lock.tryLock();
        lock.lock();
        try {
            if (flag){
                bankResult();
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }



    }

    public void bankResult()  {
        account.money = account.money - payCount;
        if(account.money > 0){
            System.out.println(username + "取了: " + payCount +", 账户剩余：" + account.money + "，线程名为：" + Thread.currentThread().getName());
        }else {
            flag = false;
            System.out.println("余额不足，不能取钱");
        }


    }

}