package p07_food_shortage;

class Robot extends BaseResident {

    private String model;

    Robot(String model, String id) {
        super(id);
        this.model = model;
    }
}