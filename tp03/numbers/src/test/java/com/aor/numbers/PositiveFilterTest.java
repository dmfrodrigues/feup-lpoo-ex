package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositiveFilterTest {

    @Test
    public void test(){
        PositiveFilter f = new PositiveFilter();
        assertEquals(f.accept(-12345), false);
        assertEquals(f.accept(-1), false);
        assertEquals(f.accept(0), false);
        assertEquals(f.accept(1), true);
        assertEquals(f.accept(12345), true);
    }
}
