package com.example.tree;

class Node {
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class BinaryTree {
    private Node leaf;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree() {
        this.leaf = null;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(Node leaf) {
        this.leaf = leaf;
        this.left = null;
        this.right = null;
    }

    public boolean isEmpty() {
        return this.leaf == null;
    }

    public void insert(Node node) {
        if (isEmpty()) {
            this.leaf = node;
        } else {
            BinaryTree newTree = new BinaryTree(node);
            if (node.getValue() < this.leaf.getValue()) {
                if (this.left == null) {
                    this.left = newTree;
                    System.out.println("Node " + node.getValue() + " inserted LEFT of " + this.leaf.getValue());
                } else {
                    this.left.insert(node);
                }
            } else if (node.getValue() > this.leaf.getValue()) {
                if (this.right == null) {
                    this.right = newTree;
                    System.out.println("Node " + node.getValue() + " inserted RIGHT of " + this.leaf.getValue());
                } else {
                    this.right.insert(node);
                }
            }
        }
    }

    public void inorder() {
        inorderRecursive(this);
    }

    private void inorderRecursive(BinaryTree node) {
        if (node != null && !node.isEmpty()) {
            inorderRecursive(node.left);
            System.out.print(node.leaf.getValue() + " ");
            inorderRecursive(node.right);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new Node(30));
        tree.insert(new Node(15));
        tree.insert(new Node(45));
        tree.insert(new Node(7));
        tree.insert(new Node(19));

        System.out.println("Inorder Traversal:");
        tree.inorder();
    }
}
