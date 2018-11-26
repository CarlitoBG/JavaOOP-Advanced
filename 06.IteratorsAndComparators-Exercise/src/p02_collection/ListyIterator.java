package p02_collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator<S extends String> implements Iterable<S>{

    private List<S> collection;
    private int index;

    ListyIterator(List<S> collection) {
        this.collection = collection;
        this.index = 0;
    }

    public boolean move(){
        if (this.hasNext()){
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        return this.index < collection.size() - 1;
    }

    public void print(){
        if (this.collection.size() == 0){
            throw new IllegalArgumentException("Invalid Operation!");
        }else {
            System.out.println(this.collection.get(this.index));
        }
    }

    public void printAll(){
        String result = String.join(" ", this.collection);
        System.out.println(result);
    }

    @Override
    public Iterator<S> iterator() {
        return new CollectionIterator();
    }

    private class CollectionIterator implements Iterator<S> {

        private int index;

        CollectionIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < collection.size();
        }

        @Override
        public S next() {
            return collection.get(index++);
        }
    }
}