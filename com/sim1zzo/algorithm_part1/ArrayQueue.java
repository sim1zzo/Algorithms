package com.sim1zzo.algorithm_part1;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }
    public void enqueue(int item){
        if (isFull())
            throw new IllegalStateException();

        items[rear] = item;
        rear = ++rear % items.length;
        count++;
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();

        var item = items[front];
        items[front] = 0;
        front = ++front % items.length;
        count--;
        return item;


    }
    public int peek(){
        if (isEmpty())
            return Integer.MIN_VALUE;
        return items[front];
    }
    @Override
    public String toString() {
        return Arrays.toString(items);
    }
    public boolean isEmpty(){
        return count == 0;
    }
    private boolean isFull(){
        return count == items.length;
    }





}
