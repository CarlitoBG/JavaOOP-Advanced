package p07_1984;

import p07_1984.contracts.Observer;
import p07_1984.contracts.Subject;
import p07_1984.factories.InstitutionFactory;
import p07_1984.factories.SubjectFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Subject> subjects = new LinkedHashMap<>();
        Map<String, Observer> observers = new LinkedHashMap<>();

        String[] tokens = reader.readLine().split("\\s+");
        int numberOfEntities = Integer.parseInt(tokens[0]);
        int numberOfInstitutions = Integer.parseInt(tokens[1]);
        int numberOfChanges = Integer.parseInt(tokens[2]);

        while (numberOfEntities-- > 0){
            tokens = reader.readLine().split("\\s+");
            String subjectId = tokens[1];

            Subject subject = SubjectFactory.createSubject(tokens);
            subjects.put(subjectId, subject);
        }

        while (numberOfInstitutions-- > 0){
            tokens = reader.readLine().split("\\s+");
            String institutionName = tokens[2];
            String[] attributesToMonitor = Arrays.stream(tokens).skip(3).toArray(String[]::new);

            Observer observer = InstitutionFactory.createInstitution(institutionName, attributesToMonitor);

            for (Subject subject : subjects.values()) {
                subject.addObserver(observer);
            }
            observers.put(institutionName, observer);
        }

        while (numberOfChanges-- > 0){
            tokens = reader.readLine().split("\\s+");

            String id = tokens[0];
            String attributeToChange = tokens[1];
            String newValue = tokens[2];

            Subject subject = subjects.get(id);
            subject.notifyObserver(attributeToChange, newValue);
        }

        for (Observer observer : observers.values()) {
            System.out.println(observer.toString());
        }
    }
}