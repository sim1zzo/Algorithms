package com.sim1zzo.algorithm_part1;

import javax.lang.model.type.MirroredTypeException;
import java.util.Arrays;

public class Stack {
    private int count;
    private int[] stack;
    private static int min = Integer.MAX_VALUE;
    private static int min2 = Integer.MAX_VALUE;

    public Stack(int capacity) {
        if (capacity <= 0 )
            throw new IllegalArgumentException("Capacity must be bigger than 0(zero).");
        stack = new int[capacity];
    }
    public void push(int item){
        if (isFull())
            incrementSize();
        stack[count++] = item;
        if (item < min) {
            min2 = min;
            min = item;
        }
    }
    public int pop(){
        if (isEmpty())
            throw new IllegalStateException();
        int removed = stack[count-1];
        if (removed == min)
            min = min2;
        count--;
        return removed;
    }
    public int peek(){
        int value = stack[count-1];
        return value;

    }

    @Override
    public String toString(){
        var arr =  Arrays.copyOfRange(stack,0,count);
        return Arrays.toString(arr) + " min value: " + getMin();
    }

    private int getMin(){
        return min;
    }



    //<--- Private methods --->
    private boolean isEmpty(){
        return count == 0;
    }
    private boolean isFull(){
        return count == stack.length;
    }
    private void incrementSize(){
        int[] array = new int[count +1];
        for (int i = 0; i< count;i++){
            array[i]= stack[i];
        }
        stack = array;
    }


    //    private int count;
//    private int[] arr = new int[5];
//
//    public void push(int item){
//        if (count == arr.length)
//            throw new StackOverflowError();
//        arr[count++] = item;
//    }
//    public int pop(){
//        if (count == 0)
//            throw new IllegalStateException();
//        return arr[--count];
//    }
//
//    @Override
//    public String toString(){
//        var content = Arrays.copyOfRange(arr,0,count);
//        return Arrays.toString(content);
//    }
//
//    public int peek(){
//        if (count ==0)
//            throw new IllegalStateException();
//        return arr[count -1];
//    }
//
//    public boolean isEmpty(){
//        return count ==0;
//    }


}
