package p03_car_shop_extended;

public class Seat implements Sellable{

    private String model;
    private String color;
    private Integer hp;
    private String countryProduced;
    private Double price;

    Seat(String model, String color, Integer hp, String countryProduced, Double price) {
        this.model = model;
        this.color = color;
        this.hp = hp;
        this.countryProduced = countryProduced;
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.hp;
    }

    @Override
    public String toString() {
        return String.format(
                "This is %s produced in %s and have %d tires",
                this.model,
                this.countryProduced,
                Car.TIRES
        );
    }
}