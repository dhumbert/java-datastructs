package com.dhwebco.datastructs;

import com.dhwebco.datastructs.nodes.TrieNode;

import java.util.List;

/**
 * Ephemeral (non-persistent) Trie. A trie is used for efficiently storing keyed data with common prefixes. A typical
 * example is storing nodes with string keys, as many strings share a prefix. So "Devin" and "Developer" will share
 * a path up to "Dev" and then diverge. With large amounts of data, this can be more efficient than storing a node
 * for every full key. Trie lookups are O(m) (where m is the length of a search string) in the worst case, which
 * is more efficient than a Hashtable worst case of O(N) (though hashtables average case is much better).
 *
 * Tries are often used for predictive text, as accessing data by prefix is so efficient.
 *
 * I took some inspiration from https://community.oracle.com/thread/2070706.
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Add a key/value.
     */
    public void add(String key, String value) {
        root.addChild(key, value);
    }

    /**
     * Find a value given a key.
     */
    public String find(String key) {
        return root.find(key);
    }

    /**
     * Get all keys.
     */
    public List<String> keys() {
        return root.keys();
    }

    /**
     * Get all keys starting with a prefix.
     */
    public List<String> keys(String prefix) {
        return root.keys(prefix);
    }
}
