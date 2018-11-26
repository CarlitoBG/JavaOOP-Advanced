package p05_comparing_objects;

public class Person implements Comparable<Person>{

    private String name;
    private int age;
    private String town;

    Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        int comparator = this.name.compareTo(person.name);

        if (comparator == 0) {
            comparator = Integer.compare(this.age, person.age);
        }

        if (comparator == 0) {
            comparator = this.town.compareTo(person.town);
        }
        return comparator;
    }
}