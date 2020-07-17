package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ListSorterTest {
    private List<Integer> list;

    @Before
    public void setupList(){
        list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);
    }

    @Test
    public void sort() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 2, 6, 1, 4, 5, 7));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();
        assertEquals(expected, sorted);
    }

    @Test
    public void sort1() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 7));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 8));
        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();
        assertEquals(expected, sorted);
    }

    @Test
    public void sort_random() {
        final int SZMIN = 10;
        final int SZMAX = 1000;
        final int IMIN = -100;
        final int IMAX = 100;
        final int N = 10;
        Random r = new Random();
        for(int i = 0; i < N; ++i){
            int sz = r.nextInt()%(SZMAX-SZMIN)+SZMIN;
            List<Integer> list = new ArrayList();
            for(int j = 0; j < sz; ++j){
                list.add(r.nextInt()%(IMAX-IMIN)+IMIN);
            }
            List<Integer> expected = new ArrayList<Integer>(list);
            Collections.sort(expected);
            ListSorter sorter = new ListSorter(list);
            List<Integer> sorted = sorter.sort();
            assertEquals(expected, sorted);
        }
    }

    @Test
    public void sort_br8726(){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,4,2));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 4));
        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();
        assertEquals(expected, sorted);
    }
}