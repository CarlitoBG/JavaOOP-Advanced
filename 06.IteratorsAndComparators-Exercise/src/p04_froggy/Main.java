package p04_froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("[ ,]+")).map(Integer::parseInt).collect(Collectors.toList());
        Lake<Integer> lake = new Lake<>(numbers);

        String endCommand = reader.readLine();
        if ("END".equals(endCommand)){
            numbers = new ArrayList<>();
            for (Integer number : lake) {
                numbers.add(number);
            }

            System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}