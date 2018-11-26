package p06_strategy_pattern;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person>{

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        int comparator = Integer.compare(firstPerson.getName().length(), secondPerson.getName().length());

        if (comparator == 0){
            comparator = Character.compare(firstPerson.getName().toLowerCase().charAt(0), secondPerson.getName().toLowerCase().charAt(0));
        }
        return comparator;
    }
}