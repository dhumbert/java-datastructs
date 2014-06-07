package com.dhwebco.datastructs;

import com.dhwebco.datastructs.nodes.BSTNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testClone() throws Exception {
        BSTNode<Integer, Integer> n1 = new BSTNode<>(1, 1);
        BSTNode<Integer, Integer> n2 = n1.clone();
        assertNotSame(n1, n2);
    }
}