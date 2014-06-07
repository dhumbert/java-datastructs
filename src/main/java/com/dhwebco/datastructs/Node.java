package com.dhwebco.datastructs;

public class Node<KEY extends Comparable<? super KEY>, VALUE> implements Cloneable {
    private KEY key;
    private VALUE value;
    private Node<KEY, VALUE> lchild;
    private Node<KEY, VALUE> rchild;
    private Node<KEY, VALUE> parent;

    public Node(KEY key, VALUE value) {
        this.key = key;
        this.value = value;
    }

    public KEY getKey() {
        return key;
    }

    public VALUE getValue() {
        return value;
    }

    public Node<KEY, VALUE> getLchild() {
        return lchild;
    }

    public void setLchild(Node lchild) {
        this.lchild = lchild;
    }

    public Node<KEY, VALUE> getRchild() {
        return rchild;
    }

    public void setRchild(Node rchild) {
        this.rchild = rchild;
    }

    public Node<KEY, VALUE> getParent() {
        return parent;
    }

    public void setParent(Node<KEY, VALUE> parent) {
        this.parent = parent;
    }

    @Override
    public Node<KEY, VALUE> clone() {
        try {
            return (Node<KEY, VALUE>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
