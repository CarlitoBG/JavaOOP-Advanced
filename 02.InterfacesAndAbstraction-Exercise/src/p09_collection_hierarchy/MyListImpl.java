package p09_collection_hierarchy;

import java.util.ArrayList;
import java.util.List;

public class MyListImpl<T> implements MyList<T> {

    private List<T> elements;

    MyListImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int used() {
        return this.elements.size();
    }

    @Override
    public T remove() {
        return this.elements.remove(0);
    }

    @Override
    public int add(T element) {
        this.elements.add(0, element);
        return 0;
    }
}