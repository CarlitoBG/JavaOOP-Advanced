package p01_generic_box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0){
            String element = reader.readLine();

            Box stringBox = new Box<>(element);
            System.out.println(stringBox.toString());
        }
    }
}