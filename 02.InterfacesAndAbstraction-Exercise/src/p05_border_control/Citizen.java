package p05_border_control;

class Citizen extends BaseResident{

    private String name;
    private int age;

    Citizen(String name, int age, String id) {
        super(id);
        this.name = name;
        this.age = age;
    }
}