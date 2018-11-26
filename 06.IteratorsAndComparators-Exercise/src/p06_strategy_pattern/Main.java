package p06_strategy_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> nameComparator = new TreeSet<>(new PersonComparatorByName());
        Set<Person> ageComparator = new TreeSet<>(new PersonComparatorByAge());

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            String[] line = reader.readLine().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);

            Person person = new Person(name, age);
            nameComparator.add(person);
            ageComparator.add(person);
        }

        nameComparator.forEach(System.out::println);
        ageComparator.forEach(System.out::println);
    }
}