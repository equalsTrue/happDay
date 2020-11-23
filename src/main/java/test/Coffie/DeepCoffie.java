package test.Coffie;

public class DeepCoffie extends Coffie {

    private String name;


    public DeepCoffie(){
        name = "deepCoffie";
    }

    @Override
    public String getCost(){
        return "4";
    }
}
