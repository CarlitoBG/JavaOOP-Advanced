package p02_generic_box_of_integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            int element = Integer.parseInt(reader.readLine());

            Box stringBox = new Box<>(element);
            System.out.println(stringBox.toString());
        }
    }
}