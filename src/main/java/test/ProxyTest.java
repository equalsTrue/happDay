package test;

public class ProxyTest {

    public static  void main(String[] args){
        UserManagerProxy proxy = new UserManagerProxy();
        UserManager userManager = (UserManager) proxy.newProxyInteface(new UserManagerImpl());
        userManager.addUser("test");
    }
}