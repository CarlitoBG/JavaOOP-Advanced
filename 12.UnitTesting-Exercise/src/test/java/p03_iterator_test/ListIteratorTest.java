package p03_iterator_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class ListIteratorTest {

    private IListIterator listIterator;

    @Before
    public void initListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("Pesho", "Gosho", "Dragan");
    }

    @Test
    public void testMoveCommandWithCorrectHasNextValueShouldReturnTrue() throws Exception {
        Assert.assertEquals(true, this.listIterator.move());
    }

    @Test
    public void testMoveCommandWithFalseHasNextShouldReturnFalse() throws Exception {
        this.listIterator = new ListIterator("Pesho");

        Assert.assertEquals(false, this.listIterator.move());
    }

    @Test
    public void testHasNextCommandWithThreeGivenParamsShouldReturnTrue() throws Exception {
        Assert.assertEquals(true, this.listIterator.hasNext());
    }

    @Test
    public void testHasNextCommandWithOneGivenParamsShouldReturnFalse() throws Exception {
        this.listIterator = new ListIterator("Pesho");

        Assert.assertEquals(false, this.listIterator.hasNext());
    }

    @Test
    public void testPrintCommandWithNonEmptyListShouldPrintElementWithCurrentIndex() throws Exception {
        String actualString = this.listIterator.print();

        String expectedStringAfterSuccessfulPrintCommand = "Pesho";

        Assert.assertEquals(expectedStringAfterSuccessfulPrintCommand, actualString);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPrintCommandWithEmptyListShouldThrowOperationNonSupportedException() throws Exception {
        this.listIterator = new ListIterator();

        this.listIterator.print();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullPassedAsParameterShouldThrowOperationNonSupportedException() throws OperationNotSupportedException {
        this.listIterator = new ListIterator((String[]) null);
    }

    @Test
    public void testConstructorShouldTakeOnlyStringsAsParameters() throws OperationNotSupportedException {
        Constructor<?>[] constructors = this.listIterator.getClass().getConstructors();
        Constructor<?> constructor = constructors[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        Type actualTypeParameter = parameterTypes[0];

        Assert.assertEquals("Parameters must be of type String!", String[].class, actualTypeParameter);
    }
}