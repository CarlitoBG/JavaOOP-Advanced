package p03_iterator_test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIterator implements IListIterator{

    private List<String> elements;
    private int index;

    ListIterator(String... elements) throws OperationNotSupportedException {
        if (elements == null){
            throw new OperationNotSupportedException("There are no passed elements!");
        }
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.index = 0;
    }

    @Override
    public boolean move(){
        if (this.index < this.elements.size() - 1){
            this.index++;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext(){
        return this.index < this.elements.size() - 1;
    }

    @Override
    public String print() throws OperationNotSupportedException {
        if (this.elements.size() == 0){
            throw new OperationNotSupportedException("Invalid Operation!");
        }
        return this.elements.get(this.index);
    }
}