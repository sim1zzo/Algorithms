package com.sim1zzo.algorithm_part2;

import java.util.ArrayList;

public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            String message = "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild ;
            return message;
        }
    }
    private Node root;

    public void insert(int item){
        var node = new Node(item);
        if (isEmpty()) {
            root = node;
            return;
        }
        var current = root;
        while (true) {
            if (item > current.value){
                if (current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
            if(item < current.value){
                if (current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
        }
    }
    public boolean find(int value){
        if (isEmpty())
            return false;
        var current = root;
        while (current!= null){
            if (value > current.value)
                current = current.rightChild;
            if (value < current.value)
                current = current.leftChild;
            else return true;
        }
        return false;
    }
    public void traversePreOrder(){
        traversePreOrder(root);
    }
    public void traverseInOrder(){
        traverseInOrder(root);
    }
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    public int height(){
        return height(root);
    }
    public int min(){
        return min(root);
    }
    public int minBST(){
        if (root == null)
            throw new IllegalStateException();
        var current = root;
        var last = current;
        while (current!= null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public boolean equals(Tree other){
        if (other == null)
            return false;
        return equals(root,other.root);
    }

    private boolean equals(Node fist, Node second){
        if (fist == null && second == null)
            return true;
        if (fist != null && second != null)
            return fist.value ==  second.value
                    && equals(fist.leftChild, second.leftChild)
                    && equals(fist.rightChild,second.rightChild);
        return false;
    }
    public boolean isBST(){
        return isBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public ArrayList<Integer> getNodesAtDistance(int distance){
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;

    }
    public void breathFirstSearch(){
        for (var i = 0; i <= height(); i++){
            for (var value: getNodesAtDistance(i))
                System.out.println(value);
        }
    }





    //<<---- Private methods ---->>

    //traversing
    private void traversePreOrder(Node root){
        if (root == null)
            return;
        // root(print)
        System.out.println(root.value);
        //left
        traversePreOrder(root.leftChild);
        //right
        traversePreOrder(root.rightChild);
    }
    private void traverseInOrder(Node root){
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }
    private void traversePostOrder(Node root){
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
    //height
    private int height(Node root){
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1+ Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }
    //find min value
    private int min(Node root){
        if (root == null)
            throw new IllegalStateException();

        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);
        return Math.min(Math.min(left,right),root.value);
    }

    private boolean isLeaf(Node node) {
        return node.rightChild == null && node.leftChild==null;
    }
    private boolean isEmpty(){
        return root == null;
    }
    private boolean isBST(Node root, int minValue, int maxValue){
        if (isEmpty())
            return true;
        if (root.value < minValue || root.value > maxValue) // out of range
            return false;
        return isBST(root.leftChild, minValue, root.value -1)
                && isBST(root.rightChild, root.value +1, maxValue);
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if (isEmpty())
            return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }
        if (distance > height()){
            throw new IllegalStateException();
        }

        getNodesAtDistance(root.leftChild,distance -1, list);
        getNodesAtDistance(root.rightChild,distance -1, list);
    }
}
