package p01_database;

import javax.naming.OperationNotSupportedException;

public interface IDatabase {
    void addNumber(Integer number) throws OperationNotSupportedException;

    void removeNumber() throws OperationNotSupportedException;

    Integer[] fetch();

    int getIndex();
}