package hell.interfaces;

import java.util.List;

public interface Repository<T> {
    void add(T hero);

    List<T> findAll();

    T findByName(String name);
}