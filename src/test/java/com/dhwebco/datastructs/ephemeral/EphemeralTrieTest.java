package com.dhwebco.datastructs.ephemeral;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EphemeralTrieTest {
    @Test
    public void testAdd() {
        EphemeralTrie trie = new EphemeralTrie();
        trie.add("Devin", "Humbert");
        trie.add("Developer", "Jones");
        trie.add("John", "Smith");
        trie.add("      !@#$%^&*()_++=-", "asdf");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInvalidKey() {
        EphemeralTrie trie = new EphemeralTrie();
        trie.add("\t", "lorem");
    }

    @Test
    public void testGet() {
        EphemeralTrie trie = new EphemeralTrie();
        trie.add("Devin", "Humbert");
        trie.add("Developer", "Jones");
        trie.add("diva", "macintyre");
        trie.add("lorem", "ipsum");
        trie.add("loremipsum", "dolor");

        assertEquals("Humbert", trie.find("Devin"));
        assertEquals("Jones", trie.find("Developer"));
        assertEquals("macintyre", trie.find("diva"));
        assertEquals("ipsum", trie.find("lorem"));
        assertEquals("dolor", trie.find("loremipsum"));
    }

    @Test
    public void testGetAll() {
        EphemeralTrie trie = new EphemeralTrie();
        trie.add("Devin", "Humbert");
        trie.add("Developer", "Jones");
        trie.add("diva", "macintyre");
        trie.add("lorem", "ipsum");
        trie.add("loremipsum", "dolor");

        List<String> possibilities = trie.keys();
        assertEquals(5, possibilities.size());
        assertTrue(possibilities.contains("Devin"));
        assertTrue(possibilities.contains("Developer"));
        assertTrue(possibilities.contains("diva"));
        assertTrue(possibilities.contains("lorem"));
        assertTrue(possibilities.contains("loremipsum"));
    }

    @Test
    public void testGetWithPrefix() {
        EphemeralTrie trie = new EphemeralTrie();
        trie.add("Devin", "Humbert");
        trie.add("Developer", "Jones");
        trie.add("diva", "macintyre");
        trie.add("lorem", "ipsum");

        List<String> possibilities = trie.keys("Dev");
        assertEquals(2, possibilities.size());
        assertTrue(possibilities.contains("Devin"));
        assertTrue(possibilities.contains("Developer"));
    }
}