package p04_work_force;

import p04_work_force.contracts.Employee;
import p04_work_force.manager.JobCollection;
import p04_work_force.models.Job;
import p04_work_force.models.employees.PartTimeEmployee;
import p04_work_force.models.employees.StandartEmployee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Employee> employees = new LinkedHashMap<>();
        JobCollection jobsCollection = new JobCollection();

        String line;
        while (true) {
            if ("End".equalsIgnoreCase(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "StandartEmployee":
                    employees.put(tokens[1], new StandartEmployee(tokens[1]));
                    break;
                case "PartTimeEmployee":
                    employees.put(tokens[1], new PartTimeEmployee(tokens[1]));
                    break;
                case "Job":
                    jobsCollection.addJob(new Job(tokens[1], Integer.parseInt(tokens[2]), employees.get(tokens[3])));
                    break;
                case "Pass":
                    String passWeek = jobsCollection.passWeek();
                    if (passWeek != null) {
                        System.out.println(passWeek);
                    }
                    break;
                case "Status":
                    if (jobsCollection.status() != null) {
                        System.out.println(jobsCollection.status());
                    }
                    break;
            }
        }
    }
}