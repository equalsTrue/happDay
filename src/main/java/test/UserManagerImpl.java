package test;

public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String username) {
        System.out.println("add user name is " +username);
    }

    @Override
    public void deleteUser(String username) {
        System.out.println(" delete user name is " +username);
    }
}
