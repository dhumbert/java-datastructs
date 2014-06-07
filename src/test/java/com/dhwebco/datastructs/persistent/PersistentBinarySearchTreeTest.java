package com.dhwebco.datastructs.persistent;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersistentBinarySearchTreeTest {

    @Test
    public void testAdd() throws Exception {
        PersistentBinarySearchTree<Integer, String> bst = new PersistentBinarySearchTree<>();
        PersistentBinarySearchTree<Integer, String> bst2 = bst.add(12, "Devin");
        assertNotNull(bst2.get(12));
        assertNull(bst.get(12));

        PersistentBinarySearchTree<Integer, String> bst3 = bst2.add(6, "Humbert");
        assertNotNull(bst3.get(6));
        assertNull(bst2.get(6));
        assertNull(bst.get(6));

        PersistentBinarySearchTree<Integer, String> bst4 = bst3.add(3, "Lorem");
        assertNotNull(bst4.get(3));
        assertNull(bst3.get(3));
        assertNull(bst2.get(3));
        assertNull(bst.get(3));

        PersistentBinarySearchTree<Integer, String> bst5 = bst4.add(1, "Ipsum");
        assertNotNull(bst5.get(1));
        assertNull(bst4.get(1));
        assertNull(bst3.get(1));
        assertNull(bst2.get(1));
        assertNull(bst.get(1));

        PersistentBinarySearchTree<Integer, String> bst6 = bst5.add(20, "Dolor");
        assertNotNull(bst6.get(20));
        assertNull(bst5.get(20));
        assertNull(bst4.get(20));
        assertNull(bst3.get(20));
        assertNull(bst2.get(20));
        assertNull(bst.get(20));

        PersistentBinarySearchTree<Integer, String> bst7 = bst6.add(40, "sit");
        assertNotNull(bst7.get(40));
        assertNull(bst6.get(40));
        assertNull(bst5.get(40));
        assertNull(bst4.get(40));
        assertNull(bst3.get(40));
        assertNull(bst2.get(40));
        assertNull(bst.get(40));

        int i = 0;
    }
}