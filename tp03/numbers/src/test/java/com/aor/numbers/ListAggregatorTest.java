package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    public class ListDeduplicatorStub implements IListDeduplicator{
        private final List<Integer> list;

        public ListDeduplicatorStub(List<Integer> list) {
            this.list = list;
        }

        public List<Integer> deduplicate(IListSorter listSorter){
            if(list.equals(new ArrayList<Integer>(Arrays.asList(1,2,4,2,5))))
                return new ArrayList<>(Arrays.asList(1,2,4,5));
            else if(list.equals(new ArrayList<Integer>(Arrays.asList(1,2,4,2))))
                return new ArrayList<>(Arrays.asList(1,2,4));
            else return new ArrayList<>();
        }
    }

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

        int distinct = aggregator.distinct(new ListDeduplicatorStub(list));

        assertEquals(4, distinct);
    }

    @Test
    public void distinct_br8726(){
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 2));
        ListAggregator aggregator = new ListAggregator(list);
        int distinct = aggregator.distinct(new ListDeduplicatorStub(list));
        assertEquals(3, distinct);
    }
}