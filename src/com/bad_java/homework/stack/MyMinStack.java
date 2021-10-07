package com.bad_java.homework.stack;

import java.util.*;

public class MyMinStack<E extends Comparable<E>> implements MinStack<E> {
    private final LinkedList<E> stack = new LinkedList<>();

    private MinElement<E> minElement;

    public void push(E value) {
        if (Objects.nonNull(minElement) && minElement.compareTo(value) >= 0) {
            minElement = new MinElement<>(value, minElement);
        }
        if (Objects.isNull(minElement))
        {
            minElement = new MinElement<>(value, null);
        }

        stack.push(value);
    }

    @Override
    public E pop() {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        E element = stack.pop();
        if (element.compareTo(minElement.getMinElement()) == 0)
        {
            minElement = minElement.getPreviousMinElement();
        }

        return element;
    }

    @Override
    public E min() {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }

        return minElement.getMinElement();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }


    private static class MinElement<E extends Comparable<E>> {
        private final E minElement;

        private final MinElement<E> previousMinElement;

        public MinElement(E minElement, MinElement<E> previousMinElement) {
            this.minElement = minElement;
            this.previousMinElement = previousMinElement;
        }


        public Integer compareTo(final E element) {
            return minElement.compareTo(element);
        }

        public E getMinElement() {
            return minElement;
        }

        public MinElement<E> getPreviousMinElement() {
            return previousMinElement;
        }
    }

    public static void main(String[] args) {
        MyMinStack<Integer> myStack = new MyMinStack<>();
        MyMinStack<Integer> myV2Stack = new MyMinStack<>();

        myStack.push(4);
        myStack.push(2);
        myStack.push(3);
        myStack.push(1);
        myStack.push(5);

        myV2Stack.push(4);
        myV2Stack.push(2);
        myV2Stack.push(3);
        myV2Stack.push(1);
        myV2Stack.push(5);

        System.out.println(myStack.min() + " " + myV2Stack.min());
        System.out.println(myStack.pop() + " " + myV2Stack.pop());
        System.out.println(myStack.min() + " " + myV2Stack.min());
        System.out.println(myStack.pop() + " " + myV2Stack.pop());
        System.out.println(myStack.min() + " " + myV2Stack.min());
        System.out.println(myStack.pop() + " " + myV2Stack.pop());
        System.out.println(myStack.min() + " " + myV2Stack.min());
        System.out.println(myStack.pop() + " " + myV2Stack.pop());
        System.out.println(myStack.min() + " " + myV2Stack.min());
        System.out.println(myStack.pop() + " " + myV2Stack.pop());
    }
}
