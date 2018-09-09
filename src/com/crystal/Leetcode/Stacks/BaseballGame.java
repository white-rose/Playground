package com.crystal.Leetcode.Stacks;

import java.util.Stack;

public class BaseballGame {

    static Stack scoreStack = new Stack();

    public static void main (String[] args) {

        String[] baseballCommands = {
                "5","-2","4","C","D","9","+","+"
        };

        //scoreStack.addAll(Arrays.asList(baseballCommands));

        System.out.println(calPoints(baseballCommands));

    }

    public static int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack();

        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        return 0;

    }

}
