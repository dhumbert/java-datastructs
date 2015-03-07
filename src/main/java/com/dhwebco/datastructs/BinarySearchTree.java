package com.dhwebco.datastructs;

import com.dhwebco.datastructs.nodes.BSTNode;

/**
 * Standard, unbalanced binary search tree implementation.
 */
public class BinarySearchTree<KEY extends Comparable<? super KEY>, VALUE> {
    private BSTNode<KEY, VALUE> root;
    private int size;

    public void add(KEY key, VALUE value) {
        BSTNode<KEY, VALUE> node = new BSTNode<>(key, value);

        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }

        size++;
    }

    private void add(BSTNode<KEY, VALUE> subRoot, BSTNode<KEY, VALUE> newNode) {
        if (subRoot != null) {
            int cmp = subRoot.getKey().compareTo(newNode.getKey());
            if (cmp < 0) {
                if (subRoot.getRchild() == null) {
                    newNode.setParent(subRoot);
                    subRoot.setRchild(newNode);
                } else {
                    add(subRoot.getRchild(), newNode);
                }
            } else if (cmp > 0) {
                if (subRoot.getLchild() == null) {
                    newNode.setParent(subRoot);
                    subRoot.setLchild(newNode);
                } else {
                    add(subRoot.getLchild(), newNode);
                }
            }
        }
    }

    public BSTNode<KEY, VALUE> get(KEY key) {
        return get(root, key);
    }

    private BSTNode<KEY, VALUE> get(BSTNode<KEY, VALUE> subRoot, KEY key) {
        if (subRoot != null) {
            int cmp = subRoot.getKey().compareTo(key);
            if (cmp == 0) {
                return subRoot;
            } else if (cmp < 0) {
                return get(subRoot.getRchild(), key);
            } else if (cmp > 0) {
                return get(subRoot.getLchild(), key);
            }
        }

        return null;
    }

    public int size() {
        return size;
    }
}
