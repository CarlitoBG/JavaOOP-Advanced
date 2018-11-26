package p02_kings_gambit.models;

public abstract class BasePerson {

    private String name;

    BasePerson(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}