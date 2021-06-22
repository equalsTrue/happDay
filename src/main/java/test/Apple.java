package test;

public class Apple extends Food {

    private String name;

    private String id;


    public Apple(String name,String id) {
        super(name);
        this.name = name;
        this.id = id;
        System.out.println("Apple public construct ----- name =" + name + "  id = " + id);
    }

    public Apple(){
        System.out.println("Apple constrouct without params");
    }



    private void printName(String name,int id){
        System.out.println("Apple private printName");
    }




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
