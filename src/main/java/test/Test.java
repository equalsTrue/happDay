package test;

public class Test {

    private String id;

    private String name;

    public Test(){}

    private Test(String id,String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private void setDeclaredMethod(String name){
        System.out.println("name is :" + name);
    }

    public void getPublicMethod(String name){
        System.out.println("public name is : "+ name);
    }
}
