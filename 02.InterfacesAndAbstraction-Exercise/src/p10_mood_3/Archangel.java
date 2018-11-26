package p10_mood_3;

public class Archangel extends GameObjectImpl{

    private int mana;

    Archangel(String userName, int level, int mana) {
        super(userName, level);
        this.mana = mana;
    }

    @Override
    protected String calcHashedPassword() {
        return new StringBuilder(super.getUserName()).reverse().toString() + (super.getUserName().length() * 21);
    }

    @Override
    public String toString() {
        return String.format("%s%s", super.toString(), this.mana * super.getLevel());
    }
}