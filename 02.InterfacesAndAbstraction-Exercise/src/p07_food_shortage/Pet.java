package p07_food_shortage;

public class Pet implements Birthday {

    private String name;
    private String birthday;

    Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}