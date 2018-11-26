package p04_bubble_sort_test;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSortAlgorithmWithArrayOfTenIntegersShouldWorkCorrectly() throws Exception {
        Integer[] arrayToSort = {44, 3, -316, 289, 5, 2, 1, 3, 0, -1};
        Integer[] expectedCorrectlySortedArray = {-316, -1, 0, 1, 2, 3, 3, 5, 44, 289};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expectedCorrectlySortedArray, arrayToSort);
    }

    @Test
    public void testSortAlgorithmWithArrayOfZeroIntegersShouldWorkCorrectly() throws Exception {
        Integer[] arrayToSort = {};
        Integer[] expectedCorrectlySortedArray = {};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expectedCorrectlySortedArray, arrayToSort);
    }

    @Test
    public void testSortAlgorithmWithArrayOfOneIntegerShouldWorkCorrectly() throws Exception {
        Integer[] arrayToSort = {33};
        Integer[] expectedCorrectlySortedArray = {33};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expectedCorrectlySortedArray, arrayToSort);
    }

    @Test
    public void testSortAlgorithmWithAlreadySortedArrayOfIntegersShouldWorkCorrectly() throws Exception {
        Integer[] arrayToSort = {1, 2, 3, 4, 5, 6, 7};
        Integer[] expectedCorrectlySortedArray = {1, 2, 3, 4, 5, 6, 7};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expectedCorrectlySortedArray, arrayToSort);
    }

    @Test(expected = NullPointerException.class)
    public void testSortAlgorithmWithNullAsGivenParametersShouldThrowNullPointerException(){
        Integer[] arrayToSort = new Integer[3];

        Bubble.sort(arrayToSort);
    }

    @Test
    public void testSortAlgorithmWithStringsAsParametersShouldWorkCorrectly() throws Exception {
        String[] arrayToSort = {"b", "aA", "Pesho", "A", "a", "ab", "PESHO", "4", "aa"};
        String[] expectedCorrectlySortedArray = {"4", "A", "PESHO", "Pesho", "a", "aA", "aa", "ab", "b"};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expectedCorrectlySortedArray, arrayToSort);
    }

    @Test
    public void testSortAlgorithmWithArrayOfTenDoublesShouldWorkCorrectly() throws Exception {
        Double[] arrayToSort = {1.125, 3.00, -3.16, 2.89, 1.1251, -3.15, 0.1, 0.0, -0.1, 25.4};
        Double[] expectedCorrectlySortedArray = {-3.16, -3.15, -0.1, 0.0, 0.1, 1.125, 1.1251, 2.89, 3.00, 25.4};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expectedCorrectlySortedArray, arrayToSort);
    }
}