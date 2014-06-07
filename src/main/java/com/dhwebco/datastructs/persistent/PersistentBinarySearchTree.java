package com.dhwebco.datastructs.persistent;

import com.dhwebco.datastructs.Node;

/**
 * Persistent, unbalanced binary search tree implementation.
 * @param <KEY>
 * @param <VALUE>
 */
public class PersistentBinarySearchTree<KEY extends Comparable<? super KEY>, VALUE> {
    private Node<KEY, VALUE> root;
    private int size;

    public PersistentBinarySearchTree<KEY, VALUE> add(KEY key, VALUE value) {
        PersistentBinarySearchTree<KEY, VALUE> newTree = new PersistentBinarySearchTree<>();
        Node<KEY, VALUE> node = new Node<>(key, value);

        if (root == null) {
            newTree.root = node;
            newTree.size = 1;
        } else {
            newTree.root = this.root.clone();
            newTree.size = this.size + 1;
            newTree.add(newTree.root, node);
        }

        return newTree;
    }

    private void add(Node<KEY, VALUE> subRoot, Node<KEY, VALUE> newNode) {
        if (subRoot != null) {
            Node<KEY, VALUE> clonedNode = (subRoot == root) ? root : subRoot.clone();
            int cmp = subRoot.getKey().compareTo(newNode.getKey());
            if (cmp < 0) {
                if (clonedNode.getRchild() == null) {
                    newNode.setParent(clonedNode);
                    clonedNode.setRchild(newNode);

                    if (clonedNode.getParent() != null) {
                        clonedNode.getParent().setRchild(clonedNode);
                    }
                } else {
                    // copy this portion of the path
                    if (subRoot.getParent() != null) {
                        subRoot.getParent().setRchild(clonedNode);
                    }
                    Node<KEY, VALUE> rchild = clonedNode.getRchild();
                    rchild.setParent(clonedNode);
                    clonedNode.setRchild(rchild);
                    add(clonedNode.getRchild(), newNode);
                }
            } else if (cmp > 0) {
                if (clonedNode.getLchild() == null) {
                    newNode.setParent(clonedNode);
                    clonedNode.setLchild(newNode);

                    if (clonedNode.getParent() != null) {
                        clonedNode.getParent().setLchild(clonedNode);
                    }
                } else {
                    // copy this portion of the path
                    if (subRoot.getParent() != null) {
                        subRoot.getParent().setLchild(clonedNode);
                    }
                    Node<KEY, VALUE> lchild = clonedNode.getLchild();
                    lchild.setParent(clonedNode);
                    clonedNode.setLchild(lchild);
                    add(clonedNode.getLchild(), newNode);
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
