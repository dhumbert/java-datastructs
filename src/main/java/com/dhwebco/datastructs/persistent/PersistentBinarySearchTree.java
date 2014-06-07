package com.dhwebco.datastructs.persistent;

import com.dhwebco.datastructs.nodes.BSTNode;

/**
 * Persistent, unbalanced binary search tree implementation.
 * @param <KEY>
 * @param <VALUE>
 */
public class PersistentBinarySearchTree<KEY extends Comparable<? super KEY>, VALUE> {
    private BSTNode<KEY, VALUE> root;
    private int size;

    public PersistentBinarySearchTree<KEY, VALUE> add(KEY key, VALUE value) {
        PersistentBinarySearchTree<KEY, VALUE> newTree = new PersistentBinarySearchTree<>();
        BSTNode<KEY, VALUE> node = new BSTNode<>(key, value);

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

    private void add(BSTNode<KEY, VALUE> subRoot, BSTNode<KEY, VALUE> newNode) {
        if (subRoot != null) {
            BSTNode<KEY, VALUE> clonedNode = (subRoot == root) ? root : subRoot.clone();
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
                    BSTNode<KEY, VALUE> rchild = clonedNode.getRchild();
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
                    BSTNode<KEY, VALUE> lchild = clonedNode.getLchild();
                    lchild.setParent(clonedNode);
                    clonedNode.setLchild(lchild);
                    add(clonedNode.getLchild(), newNode);
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
