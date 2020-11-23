package test;

public class Food {

    private String name;

    private String id;

    private Food(String name,String id){
        this.name = name;
        this.id = id;
        System.out.println("private Food name ---"+ name +", Food Id ----" +id);
    }

    public Food(){
        System.out.println("Food public constrouct");
    }

    public Food(String name){
        this.name = name;
        System.out.println("public Food name ---"+ name);
    }

    private void printName(String name,int id){
        System.out.println("Food Name :" + name);
        System.out.println("Food Id :" + id);

    }

    public void printId(String id){
        System.out.println("Food Id :" + id);
    }

    public void test(){
        System.out.println("Food test");
    }
}
