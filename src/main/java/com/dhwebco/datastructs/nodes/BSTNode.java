package com.dhwebco.datastructs.nodes;

public class BSTNode<KEY extends Comparable<? super KEY>, VALUE> implements Cloneable {
    private KEY key;
    private VALUE value;
    private BSTNode<KEY, VALUE> lchild;
    private BSTNode<KEY, VALUE> rchild;
    private BSTNode<KEY, VALUE> parent;

    public BSTNode(KEY key, VALUE value) {
        this.key = key;
        this.value = value;
    }

    public KEY getKey() {
        return key;
    }

    public VALUE getValue() {
        return value;
    }

    public BSTNode<KEY, VALUE> getLchild() {
        return lchild;
    }

    public void setLchild(BSTNode lchild) {
        this.lchild = lchild;
    }

    public BSTNode<KEY, VALUE> getRchild() {
        return rchild;
    }

    public void setRchild(BSTNode rchild) {
        this.rchild = rchild;
    }

    public BSTNode<KEY, VALUE> getParent() {
        return parent;
    }

    public void setParent(BSTNode<KEY, VALUE> parent) {
        this.parent = parent;
    }

    @Override
    public BSTNode<KEY, VALUE> clone() {
        try {
            return (BSTNode<KEY, VALUE>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
