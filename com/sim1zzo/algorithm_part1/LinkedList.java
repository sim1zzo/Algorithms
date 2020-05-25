package com.sim1zzo.algorithm_part1;

public class LinkedList {

    public class Node{
        private int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value = " + value;
        }
    }
    public Node head;
    public Node tail;
    private int count;

    public void addLast(int item){
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        tail.next = node;
        tail = node;
        count++;

    }
    public void addFirst(int item){
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        node.next = head;
        head = node;
        count++;
    }
    public int indexOf(int item){
        if (isEmpty())
            throw new IllegalStateException();
        int index = 0;
        var current = head;
        while(current != null){
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;

    }
    public boolean contains(int item){
        return indexOf(item) != -1;
    }
    public void removeFirst(){
        if (isEmpty())
            throw new IllegalStateException();

        if (head == tail)
            head = tail = null;

        var second = head.next;
        head.next = null;
        head = second;
        count--;
    }
    public void removeLast(){
        if (isEmpty())
            throw new IllegalStateException();
        if (head == tail)
            head = tail = null;
        var previous = getPrevious(tail);
        tail = previous;
        tail.next = null;
        count--;

    }
    public int[] toArray(){
        int[] array = new int[count];
        var current = head;
        int index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }
    public void reverse(){
        if (isEmpty())
            return;
        var previous = head;
        var current =  head.next;
        while(current!= null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        tail = head;
        tail.next = null;
        head = previous;



    }
    public Node getKthFromTheEnd(int k){
        if (isEmpty() || k <= 0 || k >= count)
            throw new IllegalStateException();
        var slow = head;
        var fast = head;
        for (int i = 0; i < (k-1);i++){
            fast = fast.next;
            if (fast == null)
                throw new IllegalStateException();
        }
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public void middleNode(){
        if (isEmpty())
            throw new IllegalStateException();
        var a = head;
        var b = head;
        while(b!= tail && b.next!= tail){
            a = a.next;
            b = b.next.next;
        }
        if (b == tail)
            System.out.println(a.value);
        else
            System.out.println(a.value + " and " + a.next.next);
    }
    public boolean hasLoop(){
        if (isEmpty())
            throw new IllegalStateException();
        var fast = head;
        var slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
    public LinkedList createLoop(){
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        var node = list.tail;
        list.addLast(40);
        list.addLast(50);
        list.tail.next = node;
        return list;


    }


    //<---- Private methods ---->
    private boolean isEmpty(){
        return head == null;
    }
    private Node getPrevious(Node node){
        var current = head;
        while (current!= node){
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }



































//    public boolean hasLoop(){
//        var slow = first;
//        var fast = first;
//        while (fast != null && fast.next != null ){
//            slow = slow.next;
//            fast = first.next.next;
//            if (slow == fast) return true;
//        }
//        return false;
//    }




}
