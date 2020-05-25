package com.sim1zzo.algorithm_part1;

import java.util.Arrays;
import java.util.Stack;

public class Array {
    private int[] items;
    private int count;

    /**
     * Constructor for class Array with a single parameter.
     * The @param size will set the length of the given array.
     * Length is dynamic.
     */
    public Array(int size) {
        if (size <= 0)
            throw new IllegalStateException();
        items = new int[size];
    }
    public void insert(int item){
        if (isFull())
            incrementArraySize();
        items[count++] = item;
    }
    @Override
    public String toString(){
        return Arrays.toString(items);
    }
    public int size(){
        return count;
    }
    public void removeAt(int index){
        if (isEmpty())
            throw new IllegalStateException();
        if (index < 0 || index >= size())
            throw new IllegalArgumentException("Index has to be in the range 0<=index<count");
        //Shift elements of one position starting from the given parameter.
        for (int i = index; i< size()-1; i++)
            items[i] = items[i+1];
        decreaseArraySize();
        count--;
    }
    public int indexOf(int item){
        int index=0;
        for (int i = 0; i<size(); i++){
            if (items[i] == item) return index;
            index++;
        }
        return -1;
    }
    public boolean contains(int item){
        return indexOf(item) != -1;
    }
    public int max() {
        int max = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("Array is empty.");
        }
        for (int i = 0; i < size(); i++) {
            if (items[i] >= max)
                max = items[i];
        }
        return max;
    }
    public int[] reverse(){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size();i++)
            stack.push(items[i]);
        int index = 0;
        while(!stack.empty())
            items[index++] = stack.pop();
        return items;
    }
    public void insertAt(int item, int index){
        if (!isValidIndex(index))
            throw new IllegalStateException();

        if (isFull())
            incrementArraySize();

        shiftImtesFromIndex(index);
        items[index] = item;
    }
    public Array intersect(Array array){
        if (array.isEmpty() || this.isEmpty())
            return null;

        var intersect  = new Array(count);
        for (int i : array.items){
            if (this.contains(i))
                intersect.insert(i);
        }
        if (intersect.isEmpty())
            return null;
        return intersect;


    }
    //<---- Private methods ---->
    private void shiftImtesFromIndex(int index) {
        int lastIndex = count;
        while(lastIndex > index){
            items[lastIndex] = items[lastIndex-1];
            lastIndex--;
        }
    }
    private void decreaseArraySize(){
        int[] array = new int[count-1];
        for (int i = 0; i< count-1; i++){
            array[i] = items[i];
        }
        items = array;
    }
    private void incrementArraySize() {
        int[] newItems = new int[count +1];
        for (int i = 0; i < items.length; i++)
            newItems[i] = items[i];
        items = newItems;
    }
    private boolean isEmpty(){
        return count == 0;
    }
    private boolean isFull(){
        return count == items.length;
    }
    private boolean isValidIndex(int index){
        return (index < 0 || index >= size()) ? false:true;
    }





















}
