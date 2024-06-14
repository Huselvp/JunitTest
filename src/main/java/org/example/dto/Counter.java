package org.example.dto;


public class Counter {
    private Integer count;

    public Counter() {
        this.count = 0;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public void reset() {
        count = null;
    }

    public Integer getCount() {
        return count;
    }

    public void ensureNoNegative() {
        if (count < 0) {
            throw new IllegalArgumentException("Counter cannot be negative.");
        }
    }
}