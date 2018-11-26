package p06_birthday_celebrations;

class Robot extends BaseResident {

    private String model;

    Robot(String model, String id) {
        super(id);
        this.model = model;
    }
}