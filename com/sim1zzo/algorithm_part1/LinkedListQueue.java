package com.sim1zzo.algorithm_part1;

import java.util.ArrayList;

public class LinkedListQueue {
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node first;
    private Node last;
    private int count;

    public void enqueue(int item){
        var node = new Node(item);
        if (isEmpty())
            first = last = node;

        last.next = node;
        last = node;
        count++;
    }
    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();
        if(first == last)
            first = last = null;

        int item = removeHead();
        count--;
        return item;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return count;
    }
    public int peek(){
        return first.value;
    }



    //<<---- Private methods ---->>
    private int removeHead() {
        var item = first.value;
        var second = first.next;
        first.next = null;
        first = second;
        return item;
    }






//    private class Node{
//        private int value;
//        private Node next;
//
//        public Node(int value) {
//            this.value = value;
//        }
//
//        @Override
//        public String toString() {
//            return "value =" + value;
//        }
//    }
//    private Node head;
//    private Node tail;
//    private int count;
//
//    public void enqueue(int item){
//        var node = new Node(item);
//        if (isEmpty())
//            head = tail = node;
//
//
//    }
//
//    private boolean isEmpty(){
//        return head == null;
//    }









//    private class Node{
//        private int value;
//        private Node next;
//
//        public Node(int value){
//            this.value = value;
//        }
//    }
//
//    private Node first;
//    private Node last;
//    private int count;
//    private ArrayList array = new ArrayList();
//
//    public void enqueue(int item){
//        var node = new Node(item);
//        if (isEmpty())
//            first = last = node;
//        last.next = node;
//        last = node;
//        count++;
//    }
//
//    public void dequeue(){
//        if (isEmpty())
//            throw new IllegalStateException();
//        if (first == last)
//            first = last = null;
//        var second = first.next;
//        first.next = null;
//        first = second;
//        count--;
//    }
//
//
//    private boolean isEmpty(){
//        return first == null;
//
//    }
//
//    public String toString(){
//        Node current = first;
//        while (current!= null){
//            array.add(current.value);
//            current = current.next;
//        }
//        return array.toString();
//
//    }







}
