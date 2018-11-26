package p04_generic_swap_method_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Box> boxList = new ArrayList<>();

        while (n-- > 0){
            int element = Integer.parseInt(reader.readLine());

            Box integerBox = new Box<>(element);
            boxList.add(integerBox);
        }

        String [] indices = reader.readLine().split("\\s+");
        int index1 = Integer.parseInt(indices[0]);
        int index2 = Integer.parseInt(indices[1]);

        Box.swap(boxList, index1, index2);
        boxList.forEach(System.out::println);
    }
}