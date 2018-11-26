package p02_blobs.interfaces;

import java.util.Collection;

public interface Repository<T> {

    void add(T t);

    T getByName(String name);

    Collection<T> findAll();
}