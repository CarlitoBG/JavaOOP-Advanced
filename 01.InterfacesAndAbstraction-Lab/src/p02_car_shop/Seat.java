package p02_car_shop;

import java.io.Serializable;

public class Seat implements Car, Serializable{

    private String model;
    private String color;
    private Integer hp;
    private String countryProduced;

    Seat(String model, String color, Integer hp, String countryProduced) {
        this.model = model;
        this.color = color;
        this.hp = hp;
        this.countryProduced = countryProduced;
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