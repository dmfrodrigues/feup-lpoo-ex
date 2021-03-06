package com.aor.numbers;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    private List<Integer> setupList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        return list;
    }

    @Test
    public void deduplicate() {
        List<Integer> list = setupList();

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);

        IListSorter sorter = Mockito.mock(IListSorter.class);
        Mockito.when(sorter.sort()).thenReturn(new ArrayList<>(Arrays.asList(1,2,4,5)));

        List<Integer> distinct = deduplicator.deduplicate(sorter);

        assertEquals(expected, distinct);
    }
}