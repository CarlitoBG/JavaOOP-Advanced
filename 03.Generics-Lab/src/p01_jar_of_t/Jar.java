package p01_jar_of_t;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {

    private Deque<T> content;

    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(T entity){
        this.content.push(entity);
    }

    public T remove(){
        return this.content.pop();
    }
}