package com.bad_java.homework.stack;

public interface MinStack<T> {
    void push(T value);

    T pop();

    T min();

    boolean isEmpty();
}
