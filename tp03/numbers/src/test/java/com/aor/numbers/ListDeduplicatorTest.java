package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    public class ListSorterStub implements IListSorter{
        private final List<Integer> list;
        public ListSorterStub(List<Integer> list) {
            this.list = list;
        }
        public List<Integer> sort() {
            if(list.equals(new ArrayList<Integer>(Arrays.asList(1, 2, 4, 2, 5))))
                return new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5));
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
    public void deduplicate() {
        List<Integer> list = setupList();

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorterStub(list));

        assertEquals(expected, distinct);
    }
}