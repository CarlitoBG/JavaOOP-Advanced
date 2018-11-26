package p06_strategy_pattern;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person>{

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
    }
}