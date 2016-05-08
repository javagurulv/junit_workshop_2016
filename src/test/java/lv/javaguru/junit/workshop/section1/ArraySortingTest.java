package lv.javaguru.junit.workshop.section1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArraySortingTest {

    @Test
    public void whenSortEmptyArrayThenNothingHappens() {
        int[] arr = {};
        ArraySorting.sortArray(arr);
        assertThat(arr.length, is(0));
    }

    @Test
    public void whenSortArrayWithOneElementThenNothingHappens() {
        int[] arr = {};
        ArraySorting.sortArray(arr);
        assertThat(arr[0], is(1));
    }

    @Test
    public void whenSortArrayWithTwoElementInCorrectOrderThenOrderNotChanged() {
        int[] arr = {1, 2};
        ArraySorting.sortArray(arr);
        assertThat(arr[0], is(1));
        assertThat(arr[1], is(2));
    }

    @Test
    public void whenSortArrayWithTwoElementWithNotCorrectOrderThenChangeOrder() {
        int[] arr = {2, 1};
        ArraySorting.sortArray(arr);
        assertThat(arr[0], is(1));
        assertThat(arr[1], is(2));
    }

}