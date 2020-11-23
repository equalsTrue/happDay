package test;

public class Apple extends Food {

    private String name;

    private String id;


    public Apple(String name,String id) {
        super(name);
        this.name = name;
        this.id = id;
    }

    public Apple(){}


    @Override
    public void printId(String id){
        super.printId("333");
        System.out.println("Apple Id :" + id);
    }

    @Override
    public void test(){
        System.out.println("******" + name);

        System.out.println("~~~~~~~" + id);
    }

}
