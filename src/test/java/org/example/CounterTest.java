package org.example;

import org.example.dto.Counter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CounterTest {

    @Before
    public void setUp() {
        Counter counter = new Counter();
    }

    @Test
    public void checkCounter() {
        Counter counter = new Counter();
        assertEquals(0, counter.getCount());
    }

    @Test
    public void testIncrement() {
        Counter counter = new Counter();
        counter.increment();
        assertEquals(1, counter.getCount());
        counter.increment();
        assertEquals(2, counter.getCount());
    }

    @Test
    public void testDecrement() {
        Counter counter = new Counter();
        counter.increment();
        assertEquals(1, counter.getCount());
        counter.decrement();
        assertEquals(0, counter.getCount());
    }

    @Test
    public void testReset() {
        Counter counter = new Counter();
        counter.increment();
        assertEquals(1, counter.getCount());
        counter.reset();
        assertEquals(null, counter.getCount());

    }

    @Test
    public void EnsureNotNgative() {
        Counter counter = new Counter();

    }

    @Test
    public void testEnsureNoNegative_NoException() {
        Counter counter = new Counter();
        counter.increment();
        counter.ensureNoNegative();
        assertDoesNotThrow(() -> counter.ensureNoNegative());
    }

    @Test
    public void testEnsureNoNegative_ThrowsException() {
        Counter counter = new Counter();
        counter.decrement();
        Exception exception = assertThrows(IllegalArgumentException.class, counter::ensureNoNegative);
        assertEquals("Counter cannot be negative.", exception.getMessage());
    }


}