package p01_listy_iterator;

import java.util.List;

public class ListyIterator<S extends String>{

    private List<String> collection;
    private int index;

    ListyIterator(List<String> collection) {
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
}