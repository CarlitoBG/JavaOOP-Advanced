package p02_database_extended;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class DatabaseExtended implements IDatabaseExtended{

    private static final int ARRAY_SIZE = 16;

    private Person[] people;
    private int index;

    DatabaseExtended(Integer capacity) throws OperationNotSupportedException {
        if (ARRAY_SIZE != capacity){
            throw new OperationNotSupportedException("Capacity must be 16!");
        }
        this.people = new Person[ARRAY_SIZE];
        this.index = 0;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public void add(Person person) throws OperationNotSupportedException {
        if (person.getId() == null || person.getId() < 0){
            throw new OperationNotSupportedException("Invalid id.");
        }

        if (Arrays.stream(this.people).filter(p -> p != null && Objects.equals(p.getId(), person.getId())).count() != 0){
            throw new OperationNotSupportedException("There are other users with the given id.");
        }

        if (this.index > 15){
            throw new OperationNotSupportedException("Array capacity is reached!");
        }
        this.people[this.index++] = person;
    }

    @Override
    public void remove() throws OperationNotSupportedException {
        if (this.index == 0){
            throw new OperationNotSupportedException("Database is empty!");
        }
        this.people[this.index--] = null;
    }

    @Override
    public Person findById(Long id) throws OperationNotSupportedException {
        Optional<Person> foundPersonById = Arrays.stream(this.people).filter(p -> p != null && Objects.equals(p.getId(), id)).findFirst();

        if (foundPersonById.isPresent()){
            return foundPersonById.get();
        }
        throw new OperationNotSupportedException("User with the given id is not found.");
    }

    @Override
    public Person findByUsername(String username) throws OperationNotSupportedException {
        if (username == null){
            throw new OperationNotSupportedException("Given username is not valid!");
        }

        Optional<Person> foundPersonByUsername = Arrays.stream(this.people)
                .filter(p -> p != null && Objects.equals(p.getUsername(), username)).findFirst();

        if (foundPersonByUsername.isPresent()){
            return foundPersonByUsername.get();
        }
        throw new OperationNotSupportedException("User with the given username is not found.");
    }
}