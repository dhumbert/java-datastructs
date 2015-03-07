package com.dhwebco.datastructs;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeparateChainingHashTableTest {
    /**
     * This tests putting, getting, and resizing.
     */
    @Test
    public void testTable() {
        // set a low initial capacity to ensure we get a couple of resizes during the test.
        SeparateChainingHashTable<String, String> ht = new SeparateChainingHashTable<>(2);
        ht.put("Devin", "Humbert");
        ht.put("Lorem", "Ipsum");
        ht.put("Dolor", "sit");
        ht.put("adipiscing", "elit");
        ht.put("adipiscing2", "elit2");
        ht.put("adipiscing3", "elit3");
        ht.put("adipiscing4", "elit4");
        ht.put("adipiscing5", "elit5");
        ht.put("adipiscing6", "elit6");
        ht.put("adipiscing7", "elit7");

        assertEquals("Humbert", ht.get("Devin"));
        assertEquals("Ipsum", ht.get("Lorem"));
        assertEquals("sit", ht.get("Dolor"));
        assertEquals("elit", ht.get("adipiscing"));
        assertEquals("elit2", ht.get("adipiscing2"));
        assertEquals("elit3", ht.get("adipiscing3"));
        assertEquals("elit4", ht.get("adipiscing4"));
        assertEquals("elit5", ht.get("adipiscing5"));
        assertEquals("elit6", ht.get("adipiscing6"));
        assertEquals("elit7", ht.get("adipiscing7"));
        assertNull(ht.get("asdf"));
    }
}