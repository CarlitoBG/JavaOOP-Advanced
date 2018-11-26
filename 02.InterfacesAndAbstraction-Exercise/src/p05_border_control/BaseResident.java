package p05_border_control;

public abstract class BaseResident implements Identifiable{

    private String id;

    BaseResident(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}