package p07_food_shortage;

public class Rebel implements Buyer{

    private String name;
    private int age;
    private String group;
    private int food;

    Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }
}