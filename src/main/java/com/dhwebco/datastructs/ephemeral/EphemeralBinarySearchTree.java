package com.dhwebco.datastructs.ephemeral;

import com.dhwebco.datastructs.Node;

/**
 * Standard, unbalanced binary search tree implementation.
 */
public class EphemeralBinarySearchTree<KEY extends Comparable<? super KEY>, VALUE> {
    private Node<KEY, VALUE> root;
    private int size;

    public void add(KEY key, VALUE value) {
        Node<KEY, VALUE> node = new Node<>(key, value);

        if (root == null) {
            root = node;
        } else {
            add(root, node);
        }

        size++;
    }

    private void add(Node<KEY, VALUE> subRoot, Node<KEY, VALUE> newNode) {
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

    public Node<KEY, VALUE> get(KEY key) {
        return get(root, key);
    }

    private Node<KEY, VALUE> get(Node<KEY, VALUE> subRoot, KEY key) {
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
