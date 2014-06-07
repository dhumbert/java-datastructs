package com.dhwebco.datastructs;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testClone() throws Exception {
        Node<Integer, Integer> n1 = new Node<>(1, 1);
        Node<Integer, Integer> n2 = n1.clone();
        assertNotSame(n1, n2);
    }
}