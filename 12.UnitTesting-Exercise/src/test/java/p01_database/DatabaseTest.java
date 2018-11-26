package p01_database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class DatabaseTest {

    private static final Integer ARRAY_SIZE = 16;

    private IDatabase database;

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        this.database = new Database(ARRAY_SIZE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkCapacityWithDifferentThanDefaultNumberShouldThrowException() throws OperationNotSupportedException{
        IDatabase db = new Database(10);
    }

    @Test
    public void addNumberWithCorrectDataShouldWorkProperly() throws Exception {
        this.database.addNumber(1);
        this.database.addNumber(6);
        this.database.addNumber(4);

        long expectedIndexAfterSuccessfulAddNumberCommand = 3;

        Assert.assertEquals(expectedIndexAfterSuccessfulAddNumberCommand, this.database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addNumberWithNullShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        this.database.addNumber(null);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void tryAddNumberOnFullArrayShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        for (int i = 0; i < 16; i++) {
            this.database.addNumber(i);
        }

        this.database.addNumber(17);
    }

    @Test
    public void removeNumberWithCorrectDataShouldWorkProperly() throws Exception {
        this.database.addNumber(8);
        this.database.addNumber(2);
        this.database.addNumber(5);

        this.database.removeNumber();

        long expectedIndexAfterProperRemove = 2;

        Assert.assertEquals(expectedIndexAfterProperRemove, this.database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryRemoveNumberFromEmptyDatabaseShouldThrowOperationNotSupportedException() throws OperationNotSupportedException {
        this.database.removeNumber();
    }

    @Test
    public void fetchCommandShouldReturnElementsAsArrayOfIntegers() throws Exception {
        Integer[] expectedNumbers = {1, 2, 3, 4};

        Integer[] actualResult = this.database.fetch();

        Assert.assertEquals(expectedNumbers.getClass(), actualResult.getClass());
    }

    @Test
    public void constructorShouldTakeIntegersOnlyAsParameters() throws NoSuchMethodException {
        Constructor<?>[] constructors = this.database.getClass().getConstructors();
        Constructor<?> constructor = constructors[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        Type actualTypeParameter = parameterTypes[0];

        Assert.assertEquals("Parameter must be of type Integer!", Integer.class, actualTypeParameter);
    }
}