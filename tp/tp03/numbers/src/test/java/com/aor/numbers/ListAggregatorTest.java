package com.aor.numbers;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class ListAggregatorTest {

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
    public void sum() {
        List<Integer> list = setupList();

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = setupList();

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void max_br7263(){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(-1, -4, -5));
        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();
        assertEquals(-1, max);
    }

    @Test
    public void min() {
        List<Integer> list = setupList();

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = setupList();
        ListAggregator aggregator = new ListAggregator(list);

        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(any(IListSorter.class))).thenReturn(new ArrayList<>(Arrays.asList(1,2,4,5)));

        int distinct = aggregator.distinct(deduplicator);

        assertEquals(4, distinct);
    }

    @Test
    public void distinct_br8726(){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 2));
        ListAggregator aggregator = new ListAggregator(list);

        IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
        Mockito.when(deduplicator.deduplicate(any(IListSorter.class))).thenReturn(new ArrayList<>(Arrays.asList(1,2,4)));

        int distinct = aggregator.distinct(deduplicator);
        assertEquals(3, distinct);
    }
}