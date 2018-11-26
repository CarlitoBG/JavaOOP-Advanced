package p07_custom_list;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public List<T> getCustomList() {
        return this.customList;
    }

    public void add(T element){
        this.customList.add(element);
    }

    public T remove(int index){
        return this.customList.remove(index);
    }

    public boolean contains(T element){
        return this.customList.contains(element);
    }

    public void swap(int index1, int index2){
        T element = this.customList.get(index1);
        this.customList.set(index1, this.customList.get(index2));
        this.customList.set(index2, element);
    }

    public int countGreaterThan(T element){
        int counter = 0;
        for (T item : this.customList) {
            if (element.compareTo(item) < 0){
                counter++;
            }
        }
        return counter;
    }

    public T getMax(){
        T element = this.customList.get(0);
        for (T item : this.customList) {
            if (element.compareTo(item) < 0){
                element = item;
            }
        }
        return element;
    }

    public T getMin(){
        T element = this.customList.get(0);
        for (T item : this.customList) {
            if (element.compareTo(item) > 0){
                element = item;
            }
        }
        return element;
    }
}