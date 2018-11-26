package p10_tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = reader.readLine().split("\\s+");
        Tuple<String, String> t1 = new Tuple<>(line1[0] + " " + line1[1], line1[2]);

        String[] line2 = reader.readLine().split("\\s+");
        Tuple<String, Integer> t2 = new Tuple<>(line2[0], Integer.parseInt(line2[1]));

        String[] line3 = reader.readLine().split("\\s+");
        Tuple<Integer, Double> t3 = new Tuple<>(Integer.parseInt(line3[0]), Double.parseDouble(line3[1]));

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}