package com.bad_java.homework.stack;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyMinV2Stack<E extends Comparable<E>> implements MinStack<E> {
    private ElementHolder<E> currentElement;


    @Override
    public void push(E value) {
        E minElement = isEmpty() || currentElement.getMinValue().compareTo(value) >= 0 ?
                value : currentElement.getMinValue();

        currentElement = new ElementHolder<>(value, minElement, currentElement);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E value = currentElement.getValue();
        currentElement = currentElement.getPreviousElement();

        return value;
    }

    @Override
    public E min() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return currentElement.getMinValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(currentElement);
    }


    private static class ElementHolder<T extends Comparable<T>> {
        private final T value;

        private final T minValue;

        private final ElementHolder<T> previousElement;

        public ElementHolder(T value, T minValue, ElementHolder<T> previousElement) {
            this.value = value;
            this.minValue = minValue;
            this.previousElement = previousElement;
        }

        public T getValue() {
            return value;
        }

        public T getMinValue() {
            return minValue;
        }

        public ElementHolder<T> getPreviousElement() {
            return previousElement;
        }
    }
}
