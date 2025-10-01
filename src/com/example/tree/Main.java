package com.example.tree;

class Tree {
    private Leaf leaf;
    private Tree left;
    private Tree right;

    public Tree(){
        this.leaf = null;
        this.left = null;
        this.right = null;
    }

    public Tree(Leaf leaf) {
        this.leaf = leaf;
        this.left = null;
        this.right = null;
    }

    public boolean isEmpty(){
        return this.leaf == null;
    }

    public void insert(Leaf node){
        if (isEmpty()){
            this.leaf = node;
        } else {
            Tree newTree= new Tree(node);
            if (node.getValue() < this.leaf.getValue()){
                if (this.left == null){
                    this.left = newTree;
                    System.out.println("Leaf: " + node.getValue()+ " the left " + this.leaf.getValue());
                } else {
                    this.left.insert(node);
                }
            } else if(node.getValue() > this.leaf.getValue()){
                if (this.right == null){
                    this.right = newTree;
                    System.out.println("Leaf: " + node.getValue()+ " the right " + this.leaf.getValue());
                } else {
                    this.right.insert(node);
                }

            }
        }
    }
}

class Leaf {
    private int value;

    public Leaf(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(new Leaf(30));
        tree.insert(new Leaf(15));
        tree.insert(new Leaf(45));
        tree.insert(new Leaf(7));
        tree.insert(new Leaf(19));
    }
}