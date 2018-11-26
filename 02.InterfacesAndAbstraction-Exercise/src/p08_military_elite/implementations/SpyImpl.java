package p08_military_elite.implementations;

import p08_military_elite.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy{

    private int codeNumber;

    public SpyImpl(int id, String firstName, String lastName, int codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public int getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s%nCode Number: %d", super.toString(), this.getCodeNumber());
    }
}