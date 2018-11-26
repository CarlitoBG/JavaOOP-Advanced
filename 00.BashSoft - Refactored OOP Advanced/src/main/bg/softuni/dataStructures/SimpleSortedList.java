package main.bg.softuni.dataStructures;

import main.bg.softuni.contracts.SimpleOrderedBag;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class SimpleSortedList<E extends Comparable<E>> implements SimpleOrderedBag<E> {

    private static final int DEFAULT_SIZE = 16;

    private E[] innerCollection;
    private int size;
    private Comparator<E> comparator;

    public SimpleSortedList(Class<E> type, Comparator<E> comparator, int capacity) {
        this.initializeInnerCollection(type, capacity);
        this.comparator = comparator;
    }

    public SimpleSortedList(Class<E> type, int capacity) {
        this(type, Comparable::compareTo, capacity);
    }

    public SimpleSortedList(Class<E> type, Comparator<E> comparator) {
        this(type, comparator, DEFAULT_SIZE);
    }

    public SimpleSortedList(Class<E> type) {
        this(type, Comparable::compareTo, DEFAULT_SIZE);
    }

    @Override
    public boolean remove(E element) {
        if (element == null){
            throw new IllegalArgumentException();
        }

        boolean hasBeenRemoved = false;
        int indexOfRemovedElement = 0;

        for (int i = 0; i < this.size(); i++) {
           if (this.innerCollection[i].compareTo(element) == 0){
               indexOfRemovedElement = i;
               this.innerCollection[i] = null;
               hasBeenRemoved = true;
               break;
           }
        }

        if (hasBeenRemoved){
            for (int i = indexOfRemovedElement; i < this.size() - 1; i++) {
               this.innerCollection[i] = this.innerCollection[i + 1];
            }
            this.innerCollection[this.size() - 1] = null;
            this.size--;
        }

        return hasBeenRemoved;
    }

    @Override
    public int capacity() {
        return this.innerCollection.length;
    }

    @Override
    public void add(E element) {
        if (element == null){
            throw new IllegalArgumentException();
        }

        if (this.size() >= this.innerCollection.length) {
            this.resize();
        }

        this.innerCollection[this.size()] = element;
        this.size++;
        //Arrays.sort(this.innerCollection, 0, this.size(), this.comparator);
        this.sort(this.innerCollection, this.comparator);
    }

    @Override
    public void addAll(Collection<E> elements) {
        if (elements == null){
            throw new IllegalArgumentException();
        }

        if (this.size() + elements.size() >= this.innerCollection.length) {
            this.multiResize(elements);
        }

        for (E element : elements) {
            this.innerCollection[this.size()] = element;
            this.size++;
        }

        //Arrays.sort(this.innerCollection, 0, this.size(), this.comparator);
        this.sort(this.innerCollection, this.comparator);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String joinWith(String joiner) {
        if (joiner == null){
            throw new IllegalArgumentException();
        }

        StringBuilder output = new StringBuilder();
        for (E e : this) {
            output.append(e);
            output.append(joiner);
        }

        output.setLength(output.length() - joiner.length());
        return output.toString();
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size;
            }

            @Override
            public E next() {
                return innerCollection[this.index++];
            }
        };
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < this.size(); i++) {
            if (this.innerCollection[i].compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void initializeInnerCollection(Class<E> type, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative!");
        }
        this.innerCollection = (E[]) Array.newInstance(type, capacity);
    }

    private void resize() {
        this.innerCollection = Arrays.copyOf(this.innerCollection, this.innerCollection.length * 2);
    }

    private void multiResize(Collection<E> elements) {
        int newSize = this.innerCollection.length * 2;

        while (this.size() + elements.size() >= newSize) {
            newSize *= 2;
        }

        this.innerCollection = Arrays.copyOf(this.innerCollection, newSize);
    }

    private void sort(E[] innerCollection, Comparator<E> comparator) {

        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < this.size() - 1; i++) {
                if (comparator.compare(innerCollection[i], innerCollection[i + 1]) > 0) {
                    E temp = innerCollection[i];
                    innerCollection[i] = innerCollection[i + 1];
                    innerCollection[i + 1] = temp;

                    swapped = true;
                }
            }
        } while (swapped);
    }
}