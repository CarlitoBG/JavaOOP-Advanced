package p05_comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        while (true){
            String[] line = reader.readLine().split("\\s+");
            if ("END".equals(line[0])){
                break;
            }

            String name = line[0];
            int age = Integer.parseInt(line[1]);
            String town = line[2];

            Person person = new Person(name, age, town);
            persons.add(person);
        }

        int n = Integer.parseInt(reader.readLine()) - 1;

        Person target = persons.get(n);
        int counter = 0;

        for (Person person : persons) {
            if (target.compareTo(person) == 0){
                counter++;
            }
        }

        if (counter > 1){
            System.out.println(String.format("%d %d %d", counter, persons.size() - counter, persons.size()));
        }else {
            System.out.println("No matches");
        }
    }
}