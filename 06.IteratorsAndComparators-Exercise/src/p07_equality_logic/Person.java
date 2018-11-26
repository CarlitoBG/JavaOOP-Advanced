package p07_equality_logic;

public class Person implements Comparable<Person>{

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (this.getClass() != obj.getClass())){
            return false;
        }else {
            Person person = (Person) obj;
            return this.name.equals(person.name) && this.age == person.age;
        }
    }

    @Override
    public int hashCode() {
        int hashCode = this.name.hashCode();
        hashCode = 31 * hashCode + this.age;

        return hashCode;
    }

    @Override
    public int compareTo(Person person) {
        int comparator = this.name.compareTo(person.name);

        if (comparator == 0){
            comparator = Integer.compare(this.age, person.age);
        }
        return comparator;
    }
}