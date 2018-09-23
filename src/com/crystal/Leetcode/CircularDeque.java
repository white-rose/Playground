package com.crystal.Leetcode;

import java.util.LinkedList;
import java.util.List;

public class CircularDeque {

    List<Integer> circleQueue = new LinkedList<>();


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public CircularDeque(int k) {

        for (int i = 0; i < k; i++) {
            circleQueue.add(0);
        }

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        circleQueue.add(value);

        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return 0;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return 0;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return false;
    }

}
