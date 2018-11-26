package p03_iterator_test;

import javax.naming.OperationNotSupportedException;

public interface IListIterator {

    boolean move();

    boolean hasNext();

    String print() throws OperationNotSupportedException;
}