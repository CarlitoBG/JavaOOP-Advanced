package p02_generic_box_of_integer;

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