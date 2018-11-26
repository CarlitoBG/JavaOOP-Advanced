package p01_extended_array_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;

public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T>{

    private T max(){
        BiFunction<T, T, Boolean> function = (t, t2) -> t.compareTo(t2) < 0;
        return getMaxOrMin(function);
    }

    private T min(){
        BiFunction<T, T, Boolean> function = (t, t2) -> t.compareTo(t2) > 0;
        return getMaxOrMin(function);
    }

    private T getMaxOrMin(BiFunction<T, T, Boolean> function){
        T maxOrMin = null;
        Iterator<T> iterator = super.iterator();
        while (iterator.hasNext()){
            T nextElement = iterator.next();
            if (maxOrMin == null || function.apply(maxOrMin, nextElement)){
                maxOrMin = nextElement;
            }
        }
        return maxOrMin;
    }

    public static void main(String[] args) {
        ExtendedArrayList<Integer> numbers = new ExtendedArrayList<>();
        numbers.add(100);
        numbers.add(1000);
        numbers.add(-100);
        numbers.add(100000);
        numbers.add(101);

        System.out.println(numbers.max());
        System.out.println(numbers.min());
    }
}