package p04_generic_swap_method_integer;

import java.util.List;

public class Box<T> {

    private T element;

    public Box(T string) {
        this.element = string;
    }

    public static <T> void swap(List<T> list, int index1, int index2){
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.element.getClass().getName(), this.element);
    }
}