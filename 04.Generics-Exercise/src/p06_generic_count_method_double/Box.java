package p06_generic_count_method_double;

import java.util.List;

public class Box{

    public static <T extends Comparable<T>> int countGreaterValues(List<T> list, T element){
        int count = 0;
        for (T item : list) {
            if (element.compareTo(item) < 0){
                count++;
            }
        }

        return count;
    }
}