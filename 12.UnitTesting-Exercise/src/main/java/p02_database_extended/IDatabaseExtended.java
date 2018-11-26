package p02_database_extended;

import javax.naming.OperationNotSupportedException;

public interface IDatabaseExtended {
    int getIndex();

    void add(Person person) throws OperationNotSupportedException;

    void remove() throws OperationNotSupportedException;

    Person findById(Long id) throws OperationNotSupportedException;

    Person findByUsername(String username) throws OperationNotSupportedException;
}