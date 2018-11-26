package p07_food_shortage;

class Citizen extends BaseResident implements Birthday, Buyer{

    private String name;
    private int age;
    private String birthday;
    private int food;

    Citizen(String name, int age, String id, String birthday) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.food = 0;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }
}