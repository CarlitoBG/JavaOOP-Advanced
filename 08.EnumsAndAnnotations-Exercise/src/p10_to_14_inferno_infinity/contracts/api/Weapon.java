package p10_to_14_inferno_infinity.contracts.api;

public interface Weapon extends Comparable<Weapon>{

    String getName();

    void addGem(String gemType, int index);

    void removeGem(int index);

    double getItemLevel();

    String print();
}