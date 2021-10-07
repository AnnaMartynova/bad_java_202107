package com.bad_java.homework.stack;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Stack;

class StackMin extends Exception{

     static Stack<Integer> stack = new Stack<>();
     static Stack<Integer> min = new Stack<>();

    public static void push(int x) {
        if (stack.empty() || x <= min.peek()) {
            stack.push(x);
            min.push(x);
        }
        if (x > min.peek()) {
            stack.push(x);
        }
    }

    public static void pop() {
        if (stack.empty()) {
            System.out.println("Stack is empty!!");
        }
        if (stack.peek() <= min.peek()) {
            stack.pop();
            min.pop();
        } else stack.pop();

    }

    static class Main {
        public static void main(String[] args) {



//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Введите число:");
//            int x = scanner.nextInt();
//            System.out.println("Введите команду push или pop:");
//            String f = scanner.nextLine();
//
//            if(f.equals("push")){
//                StackMin.push(x);
//                System.out.println("Текущий стек: " + stack);
//                System.out.println("Текущий стек min: " + min);
//            }
//            if(f.equals("pop")){
//                StackMin.pop();
//                System.out.println("Текущий стек: " + stack);
//                System.out.println("Текущий стек min: " + min);
//            }

        }
    }
}