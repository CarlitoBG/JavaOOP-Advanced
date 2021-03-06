package p09_custom_list_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public int getSize(){
        return this.customList.size();
    }

    public T getElement(int index) {
        return this.customList.get(index);
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

    @Override
    public Iterator<T> iterator() {
        return this.customList.iterator();
    }
}