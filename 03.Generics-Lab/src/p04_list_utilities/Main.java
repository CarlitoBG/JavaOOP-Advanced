package p04_list_utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 33, 6, 4, -47, 8, 9, 5);

        int maxInteger = ListUtils.getMax(integers);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        String minString = ListUtils.getMin(strings);

        System.out.println(maxInteger);
        System.out.println(minString);
    }
}