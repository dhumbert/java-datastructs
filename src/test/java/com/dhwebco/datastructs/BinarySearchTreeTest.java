package com.dhwebco.datastructs;

import com.dhwebco.datastructs.BinarySearchTree;
import com.dhwebco.datastructs.nodes.BSTNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void testAddAndSize() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.add(12, "Devin");
        bst.add(1, "Humbert");
        bst.add(7, "Lorem");
        bst.add(45, "Ipsum");
        assertEquals(4, bst.size());
    }

    @Test
    public void testGet() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.add(12, "Devin");
        bst.add(1, "Humbert");
        bst.add(7, "Lorem");
        bst.add(45, "Ipsum");

        BSTNode<Integer, String> found = bst.get(7);
        assertEquals(new Integer(7), found.getKey());
        assertEquals("Lorem", found.getValue());

        BSTNode<Integer, String> notFound = bst.get(123);
        assertNull(notFound);
    }

    @Test
    public void testParent() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.add(12, "Devin");
        bst.add(1, "Humbert");
        bst.add(7, "Lorem");
        bst.add(45, "Ipsum");

        BSTNode<Integer, String> found = bst.get(7);
        assertEquals(new Integer(1), found.getParent().getKey());
    }
}