package com.company;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class SuperStack {



    public static void main (String args[]) {

        superStack(new String[]{

        });

    }

    static void superStack(String[] operations) {

        Stack<Integer> superStack = new Stack();
        for (String s : operations) {
            String[] operationAndValues = s.split(" ");

            if (s.contains("push")) {
                int value = Integer.valueOf(operationAndValues[1]);
                superStack.push(value);
                System.out.println(superStack.peek());
            } else if (s.contains("pop")) {
                superStack.pop();
                try {
                    System.out.println(superStack.peek());
                } catch (EmptyStackException ex) {
                    System.out.println("EMPTY");
                }
            } else if (s.contains("inc")) {
                int numBottomElements = Integer.valueOf(operationAndValues[1]);
                int incrementBy = Integer.valueOf(operationAndValues[2]);
                Object[] stackArray = superStack.toArray();
                for (int i = 0; i < numBottomElements; i++) {
                    int value = (Integer)stackArray[i];
                    stackArray[i] = value += incrementBy;
                }

                Stack redefinedStack = new Stack();
                redefinedStack.addAll(Arrays.asList(stackArray));
                superStack = redefinedStack;
                System.out.println(superStack.peek());
            }

        }
    }



}
