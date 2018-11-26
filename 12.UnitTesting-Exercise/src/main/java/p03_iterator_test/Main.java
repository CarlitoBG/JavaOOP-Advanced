package p03_iterator_test;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] createParams = reader.readLine().split("\\s+");

            String[] elements = Arrays.copyOfRange(createParams, 1, createParams.length);
            IListIterator listIterator = new ListIterator(elements);

            String command;
            while (true) {
                if ("END".equals(command = reader.readLine())) {
                    break;
                }

                switch (command) {
                    case "Move":
                        System.out.println(listIterator.move());
                        break;
                    case "HasNext":
                        System.out.println(listIterator.hasNext());
                        break;
                    case "Print":
                        System.out.println(listIterator.print());
                        break;
                }
            }
        }catch (OperationNotSupportedException onse){
            System.out.println(onse.getMessage());
        }
    }
}