package p03_coffee_machine;

public class Coffee {

    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.coffeeSize, this.coffeeType);
    }
}