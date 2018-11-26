package p10_mood_3;

public abstract class GameObjectImpl implements GameObject {

    private String userName;
    private int level;
    private String hashedPassword;

    GameObjectImpl(String userName, int level) {
        this.userName = userName;
        this.level = level;
        this.hashedPassword = this.calcHashedPassword();
    }

    protected abstract String calcHashedPassword();

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n", this.getUserName(), this.getHashedPassword(), this.getClass().getSimpleName());
    }
}