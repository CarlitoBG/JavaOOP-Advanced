package test.bg.softuni.dataStructures;

import main.bg.softuni.contracts.SimpleOrderedBag;
import main.bg.softuni.dataStructures.SimpleSortedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SimpleOrderedBagTests {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp(){
        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyConstructorShouldReturnZeroAsSizeAndDefaultCapacity(){
        this.names = new SimpleSortedList<>(String.class);

        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testConstructorWithGivenInitialCapacityShouldHaveCorrectCapacity(){
        this.names = new SimpleSortedList<>(String.class, 20);

        Assert.assertEquals(20, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testConstructorWithInitialComparatorShouldHaveDefaultCapacity(){
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER);

        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testConstructorWithAllParamsShouldHaveCorrectCapacityAndZeroSize(){
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER, 30);

        Assert.assertEquals(30, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testAddMethodWithValidParamShouldIncreaseSizeCorrectly(){
        this.names.add("Nasko");

        Assert.assertEquals(1, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodWithNullShouldThrowIllegalArgumentException(){
        this.names.add(null);
    }

    @Test
    public void testAddMethodWithUnsortedDataShouldHoldItSorted(){
        this.names.add("Rosen");
        this.names.add("Georgi");
        this.names.add("Balkan");

        Iterator<String> iterator = this.names.iterator();

        Assert.assertEquals("Balkan", iterator.next());
        Assert.assertEquals("Georgi", iterator.next());
        Assert.assertEquals("Rosen", iterator.next());
    }

    @Test
    public void testAddMethodWithMoreThanInitialCapacityShouldIncreaseCapacitySuccessfully() {
        for (int i = 0; i < 17; i++) {
            this.names.add("Rosen" + i);
        }

        Assert.assertEquals(17, this.names.size());
        Assert.assertNotEquals(16, this.names.capacity());
    }

    @Test
    public void testAddAllMethodWithValidParamShouldIncreasesSizeSuccessfully() {
        List<String> listOfNames = new ArrayList<>();
        listOfNames.add("Pesho");
        listOfNames.add("Ivan");

        this.names.addAll(listOfNames);

        Assert.assertEquals(2, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllMethodWithNullAsParamShouldThrowIllegalArgumentException() {
        this.names.addAll(null);
    }

    @Test
    public void testAddAllMethodWithValidParamsShouldKeepElementsSorted() {
        List<String> listOfNames = new ArrayList<>();
        Collections.addAll(listOfNames, "Pesho", "Ivan");

        this.names.addAll(listOfNames);
        Iterator<String> iterator = this.names.iterator();

        Assert.assertEquals("Ivan", iterator.next());
        Assert.assertEquals("Pesho", iterator.next());
    }

    @Test
    public void testRemoveMethodWithValidElementShouldDecreasesSizeCorrectly() {
        this.names.add("Pesho");
        this.names.remove("Pesho");

        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testRemoveMethodWithValidElementShouldRemoveSelectedOne() {
        List<String> listOfNames = new ArrayList<>();
        Collections.addAll(listOfNames, "Ivan", "Nasko");
        this.names.addAll(listOfNames);

        this.names.remove("Ivan");

        Assert.assertEquals(false, this.names.contains("Ivan"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveMethodWithNullAsParamShouldThrowIllegalArgumentException() {
        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithMethodWithNullAsParamShouldThrowIllegalArgumentException() {
        this.names.joinWith(null);
    }

    @Test
    public void testJoinWithMethodWithValidParamShouldWorkFine() {
        List<String> listOfNames = new ArrayList<>();
        Collections.addAll(listOfNames, "Ivan", "Pesho");

        this.names.addAll(listOfNames);

        Assert.assertEquals("Ivan, Pesho", this.names.joinWith(", "));
    }
}