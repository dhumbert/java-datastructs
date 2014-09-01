package com.dhwebco.datastructs.nodes;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    private char prefix;
    private String value;

    private TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[94];
    }

    private TrieNode(char prefix) {
        this();
        this.prefix = prefix;
    }

    /**
     * Add a child node recursively.
     */
    public void addChild(String key, String value) {
        int childPosition = getFirstCharCode(key);

        if (children[childPosition] == null) {
            children[childPosition] = new TrieNode(key.charAt(0));
        }

        if (key.length() > 1) {
            children[childPosition].addChild(key.substring(1), value);
        } else { // end of key
            children[childPosition].value = value;
        }
    }

    public String find(String key) {
        int childPosition = getFirstCharCode(key);

        if (children[childPosition] == null) {
            return null;
        }

        if (key.length() == 1 && children[childPosition].value != null) {
            return children[childPosition].value;
        } else {
            return children[childPosition].find(key.substring(1));
        }
    }

    /**
     * Get all children.
     */
    public List<String> keys() {
        return keys(new StringBuilder());
    }

    /**
     * Get all children with a built prefix (for recursion).
     */
    public List<String> keys(StringBuilder builtPrefix) {
        if (prefix > 0) {
            builtPrefix.append(prefix);
        }

        List<String> keys = new ArrayList<>();

        if (value != null) {
            keys.add(builtPrefix.toString());
        }

        for (TrieNode child : children) {
            if (child != null) {
                keys.addAll(child.keys(new StringBuilder(builtPrefix)));
            }
        }

        return keys;
    }

    /**
     * Get all keys that start with a prefix.
     */
    public List<String> keys(String prefix) {
        return keys(prefix, new StringBuilder());
    }

    /**
     * Get all keys that start with a prefix, with a built prefix (for recursion).
     */
    public List<String> keys(String prefix, StringBuilder builtPrefix) {
        List<String> keys = new ArrayList<>();

        if (value != null) {
            keys.add(builtPrefix.toString());
        }

        if (prefix.length() > 0) { // still looking for matching
            builtPrefix.append(prefix.charAt(0));
            int childPosition = getFirstCharCode(prefix);

            if (children[childPosition] != null) {
                keys.addAll(children[childPosition].keys(prefix.substring(1), builtPrefix));
            }
        } else { // exhausted prefix, so add all children
            for (TrieNode child : children) {
                if (child != null) {
                    keys.addAll(child.keys(new StringBuilder(builtPrefix)));
                }
            }
        }

        return keys;
    }

    /**
     * Get the ASCII code of the first character of a string. Also validates that it's in acceptable range.
     */
    private int getFirstCharCode(String word) {
        int pos = word.charAt(0) - 32;
        if (pos < 0 || pos > 93) {
            throw new IndexOutOfBoundsException("Keys must consist only of ASCII characters between 32 and 126.");
        } else {
            return pos;
        }
    }
}
