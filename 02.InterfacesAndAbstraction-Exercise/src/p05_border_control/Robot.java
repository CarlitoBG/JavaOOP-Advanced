package p05_border_control;

class Robot extends BaseResident{

    private String model;

    Robot(String model, String id) {
        super(id);
        this.model = model;
    }
}