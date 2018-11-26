package p01_listy_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            List<String> elements = Arrays.stream(reader.readLine().split("\\s+")).skip(1).collect(Collectors.toList());
            ListyIterator<String> listyIterator = new ListyIterator<>(elements);

            while (true) {
                String command = reader.readLine();
                if ("END".equals(command)) {
                    break;
                }

                switch (command) {
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "HasNext":
                        System.out.println(listyIterator.hasNext());
                        break;
                    case "Print":
                        listyIterator.print();
                        break;
                }
            }
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}