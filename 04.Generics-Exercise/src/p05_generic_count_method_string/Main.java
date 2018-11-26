package p05_generic_count_method_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<String> data = new ArrayList<>();

        while (n-- > 0){
            String element = reader.readLine();
            data.add(element);
        }

        String valueToCompare = reader.readLine();

        int count = Box.countGreaterValues(data, valueToCompare);

        System.out.println(count);
    }
}