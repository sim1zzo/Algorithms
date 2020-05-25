package com.sim1zzo.algorithm_part1;

import java.util.Arrays;
import java.util.Stack;


public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }
    public void add(int item) {
        if (isFull())
            increaseSize();
        var last = shiftItemsToTheRight(item);
        items[last] = item;
        count++;
    }
    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }
    public int[] reverse(){
        if (isEmpty())
            throw new IllegalStateException();

        Stack<Integer> reverser = new Stack<>();
        for (int i = 0; i < count; i++)
            reverser.push(items[i]);

        int index = 0;
        while(!reverser.empty())
            items[index++] = reverser.pop();

        return items;

    }


    @Override
    public String toString() {
        return "items =" + Arrays.toString(items);
    }

    //<<---- Private methods ---->>
    private boolean isFull(){
        return count == items.length;
    }
    private boolean isEmpty(){
        return count ==0;
    }
    private int shiftItemsToTheRight(int item){
        int i;
        for (i = count-1; i>=0; i--){
            if (items[i] > item)
                items[i+1] = items[i];
            else
                break;
        }
        return i+1;
    }
    private void increaseSize(){
        int[] newArray = new int[count +1];
        for (int i =0; i< count ;i++){
            newArray[i] = items[i];
        }
        items = newArray;
    }






//
//    public int remove(){
//        if (isEmpty())
//            throw new IllegalStateException();
//        return items[--count];
//    }

//
//    public int[] reverse(int k){
//        if (isEmpty())
//            throw new IllegalStateException();
//        Stack<Integer> stack = new Stack<>();
//        for (int i =0; i<=k; i++)
//            stack.push(items[i]);
//
//        int index = 0;
//        while (!stack.isEmpty()){
//            items[index++] = stack.pop();
//        }
//        return items;
//
//    }


//
//    public int[] reverse(int k){
//        if (k >= count)
//            throw new IllegalArgumentException();
//        var stack = new Stack<Integer>();
//        for (int i =0; i <= k ;i++)
//            stack.push(items[i]);
//        int i = 0;
//        while (!stack.empty()){
//            items[i++] = stack.pop();
//        }
//        return items;
//
//
//    }



}
