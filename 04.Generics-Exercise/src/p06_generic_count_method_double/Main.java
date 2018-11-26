package p06_generic_count_method_double;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Double> data = new ArrayList<>();

        while (n-- > 0){
            double element = Double.parseDouble(reader.readLine());
            data.add(element);
        }

        double valueToCompare = Double.parseDouble(reader.readLine());

        int count = Box.countGreaterValues(data, valueToCompare);

        System.out.println(count);
    }
}