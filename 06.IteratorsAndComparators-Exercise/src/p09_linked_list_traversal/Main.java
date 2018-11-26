package p09_linked_list_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyLinkedList<Integer> list = new MyLinkedListImpl<>();

        int number = Integer.parseInt(reader.readLine());

        for (int i = 0; i < number; i++) {
            String[] input = reader.readLine().split("\\s+");

            if ("Add".equals(input[0])) {
                list.add(Integer.valueOf(input[1]));
            } else {
                list.remove(Integer.valueOf(input[1]));
            }
        }

        System.out.println(list.getSize());
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}