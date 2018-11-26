package p03_ferrari;

public class Ferrari implements Car{

    private String model;
    private String driverName;

    Ferrari(String driverName) {
        this.driverName = driverName;
        this.setModel();
    }

    private void setModel() {
        this.model = "488-Spider";
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", this.getModel(), this.useBrakes(), this.pushGasPedal(), this.getDriverName());
    }
}