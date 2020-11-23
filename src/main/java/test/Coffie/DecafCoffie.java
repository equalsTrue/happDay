package test.Coffie;

public class DecafCoffie extends Coffie{

    private String name;

    public DecafCoffie(){
        name = "DecafCoffie";
    }

    @Override
    public String getCost() {
        return "3";
    }
}
