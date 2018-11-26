package p06_birthday_celebrations;

class Citizen extends BaseResident implements Birthday{

    private String name;
    private int age;
    private String birthday;

    Citizen(String name, int age, String id, String birthday) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}