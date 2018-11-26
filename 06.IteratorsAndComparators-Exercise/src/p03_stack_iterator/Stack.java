package p03_stack_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<I extends Integer> implements Iterable<I>{

    private List<I> stack;

    Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(List<I> elements){
        this.stack.addAll(elements);
    }

    public void pop(){
        if (this.iterator().hasNext()) {
            this.stack.remove(this.stack.size() - 1);
            return;
        }
        System.out.println("No elements");
    }

    @Override
    public Iterator<I> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<I> {

        private int index;

        StackIterator() {
            this.index = stack.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public I next() {
            return stack.get(index--);
        }
    }
}