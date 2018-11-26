package p02_database_extended;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DatabaseExtendedTest {

    private static final Integer ARRAY_SIZE = 16;

    private IDatabaseExtended databaseExtended;

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        this.databaseExtended = new DatabaseExtended(ARRAY_SIZE);
    }

    @Test
    public void addPersonWithCorrectDataShouldWorkProperly() throws Exception {
        Person personMock1 = mock(Person.class);
        when(personMock1.getId()).thenReturn(1L);
        when(personMock1.getUsername()).thenReturn("Pesho");

        Person personMock2 = mock(Person.class);
        when(personMock2.getId()).thenReturn(2L);
        when(personMock2.getUsername()).thenReturn("Gosho");

        this.databaseExtended.add(personMock1);
        this.databaseExtended.add(personMock2);

        int expectedIndexAfterTwoSuccessfulAddCommands = 2;

        Assert.assertEquals(expectedIndexAfterTwoSuccessfulAddCommands, this.databaseExtended.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithNegativeIdShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        Person personMock1 = mock(Person.class);
        when(personMock1.getId()).thenReturn(-1L);
        when(personMock1.getUsername()).thenReturn("Pesho");

        this.databaseExtended.add(personMock1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithNullAsIdShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        Person personMock1 = mock(Person.class);
        when(personMock1.getId()).thenReturn(null);
        when(personMock1.getUsername()).thenReturn("Pesho");

        this.databaseExtended.add(personMock1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addPersonWithExistingIdShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        Person personMock1 = mock(Person.class);
        when(personMock1.getId()).thenReturn(1L);
        when(personMock1.getUsername()).thenReturn("Pesho");

        Person personMock2 = mock(Person.class);
        when(personMock2.getId()).thenReturn(1L);
        when(personMock2.getUsername()).thenReturn("Gosho");

        this.databaseExtended.add(personMock1);
        this.databaseExtended.add(personMock2);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void tryAddPersonOnFullArrayShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        for (int i = 0; i < 16; i++) {
            Person personMock = mock(Person.class);
            when(personMock.getId()).thenReturn(i + 1L);
            when(personMock.getUsername()).thenReturn("Pesho" + i);

            this.databaseExtended.add(personMock);
        }

        Person personMock1 = mock(Person.class);
        when(personMock1.getId()).thenReturn(17L);
        when(personMock1.getUsername()).thenReturn("Gosho");

        this.databaseExtended.add(personMock1);
    }

    @Test
    public void removePersonWithCorrectDataShouldWorkProperly() throws Exception {
        Person personMock1 = mock(Person.class);
        when(personMock1.getId()).thenReturn(1L);
        when(personMock1.getUsername()).thenReturn("Gosho");
        this.databaseExtended.add(personMock1);

        this.databaseExtended.remove();

        int expectedIndexAfterSuccessfulRemoveCommand = 0;

        Assert.assertEquals(expectedIndexAfterSuccessfulRemoveCommand, this.databaseExtended.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removePersonFromEmptyDatabaseShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {

        this.databaseExtended.remove();
    }

    @Test
    public void findPersonByIdWithCorrectDataShouldWorkProperly() throws Exception {
        Person personMock = mock(Person.class);
        when(personMock.getId()).thenReturn(3L);
        this.databaseExtended.add(personMock);

        Person actualPerson = this.databaseExtended.findById(3L);

        Assert.assertEquals(personMock, actualPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonByIdWithNonExistingPersonShouldThrowOperationNotSupportedException() throws Exception {
        Person personMock = mock(Person.class);
        when(personMock.getId()).thenReturn(5L);
        this.databaseExtended.add(personMock);

        this.databaseExtended.findById(13L);
    }

    @Test
    public void findPersonByUsernameWithCorrectDataShouldWorkProperly() throws Exception {
        Person personMock = mock(Person.class);
        when(personMock.getUsername()).thenReturn("Dragan");
        this.databaseExtended.add(personMock);

        Person actualPerson = this.databaseExtended.findByUsername("Dragan");

        Assert.assertEquals(personMock, actualPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonByUsernameWithNonExistingPersonShouldThrowOperationNotSupportedException() throws Exception {
        Person personMock = mock(Person.class);
        when(personMock.getUsername()).thenReturn("Gosho");
        this.databaseExtended.add(personMock);

        this.databaseExtended.findByUsername("Petkan");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findPersonByUsernameWithNullAsUsernameShouldThrowOperationNotSupportedException() throws Exception {
        Person personMock = mock(Person.class);
        when(personMock.getUsername()).thenReturn("Gosho");
        this.databaseExtended.add(personMock);

        this.databaseExtended.findByUsername(null);
    }
}