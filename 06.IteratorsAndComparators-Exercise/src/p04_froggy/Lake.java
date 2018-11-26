package p04_froggy;

import java.util.Iterator;
import java.util.List;

public class Lake<I extends Integer> implements Iterable<I> {

    private List<I> numbers;

    Lake(List<I> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<I> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<I> {

        private int index;

        Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < numbers.size();
        }

        @Override
        public I next() {
            I element = numbers.get(this.index);

            this.index += 2;
            if (!this.hasNext() && this.index % 2 == 0){
                this.index = 1;
            }

            return element;
        }
    }
}