package p01_database;

import javax.naming.OperationNotSupportedException;

public class Database implements IDatabase{

    private static final int ARRAY_SIZE = 16;

    private Integer[] integers;
    private int index;

    Database(Integer capacity) throws OperationNotSupportedException {
        if (ARRAY_SIZE != capacity){
            throw new OperationNotSupportedException("Capacity must be 16!");
        }
        this.integers = new Integer[ARRAY_SIZE];
        this.index = 0;
    }

    public int getIndex() {
        return this.index;
    }

    public void addNumber(Integer number) throws OperationNotSupportedException {
        if (number == null){
            throw new OperationNotSupportedException("Number is null.");
        }

        if (this.index > 15){
            throw new OperationNotSupportedException("Array capacity is reached!");
        }
        this.integers[this.index++] = number;
    }

    public void removeNumber() throws OperationNotSupportedException {
        if (this.index == 0){
            throw new OperationNotSupportedException("Database is empty.");
        }
        this.integers[this.index--] = null;
    }

    public Integer[] fetch(){
        return this.integers;
    }
}