package p01_generic_box;

public class Box<T> {

    private T element;

    public Box(T string) {
        this.element = string;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.element.getClass().getName(), this.element);
    }
}