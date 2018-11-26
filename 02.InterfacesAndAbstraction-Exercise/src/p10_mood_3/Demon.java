package p10_mood_3;

public class Demon extends GameObjectImpl{

    private double energy;

    Demon(String userName, int level, double energy) {
        super(userName, level);
        this.energy = energy;
    }

    @Override
    protected String calcHashedPassword() {
        return String.valueOf(super.getUserName().length() * 217);
    }

    @Override
    public String toString() {
        return String.format("%s%s", super.toString(), this.energy * super.getLevel());
    }
}