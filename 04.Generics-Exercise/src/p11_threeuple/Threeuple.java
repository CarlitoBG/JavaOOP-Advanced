package p11_threeuple;

public class Threeuple<T, E, K> {

    private T item1;
    private E item2;
    private K item3;

    public Threeuple(T item1, E item2, K item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return this.item1 + " -> " + this.item2 + " -> " + this.item3;
    }
}