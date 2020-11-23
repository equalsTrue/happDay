package test.Coffie;

public class Mocha extends CondimentDecorator {

    Coffie coffie;

    public Mocha(Coffie coffie){
        this.coffie = coffie;
    }

    @Override
    public String getName() {
        return coffie.getName() + "  .Mocha";
    }

    @Override
    public String getCost() {
        return null;
    }
}
