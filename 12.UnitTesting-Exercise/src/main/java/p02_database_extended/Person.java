package p02_database_extended;

public class Person {

    private long id;
    private String username;

    public Person(long id, String username) {
        this.id = id;
        this.username = username;
    }

    Long getId() {
        return this.id;
    }

    String getUsername() {
        return this.username;
    }
}