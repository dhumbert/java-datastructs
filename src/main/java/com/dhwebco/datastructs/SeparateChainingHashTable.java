package com.dhwebco.datastructs;

/**
 * A hash table implementation. It uses Java's built in hashCode() for computing hashes. The collision strategy
 * is separate chaining, which means that each bucket has a linked list of entries.
 * The table is backed by a dynamically-growing array. Delete operations are not currently supported.
 */
public class SeparateChainingHashTable<K extends Comparable<K>, V> {
    private class ChainNode {
        private K key;
        private V value;
        private ChainNode next;

        private ChainNode(final K key, final V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private int threshold;
    private ChainNode[] buckets;

    /**
     * Constructor with a default initialCapacity.
     */
    public SeparateChainingHashTable() {
        this(8);
    }

    public SeparateChainingHashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        resize(this.capacity);
    }

    /**
     * Calculates and sets the threshold at which the backing array will be resized.
     */
    private void calculateThreshold() {
        float loadFactor = 0.75f;
        this.threshold = (int) Math.floor(this.capacity * loadFactor);
    }

    /**
     * Resizes the backing array. Rehashes and copies entries.
     */
    private void resize(int capacity) {
        calculateThreshold();

        ChainNode[] newBuckets = new SeparateChainingHashTable.ChainNode[capacity];

        // if we have entries, re-hash and copy them.
        if (size > 0) {
            for (int i = 0; i < buckets.length; i++) {
                for (ChainNode c = buckets[i]; c != null; c = c.next) {
                    addItem(newBuckets, c.key, c.value);
                }
            }
        }

        buckets = newBuckets;
    }

    /**
     * Determines whether the backing array needs to be resized.
     */
    private void checkForResize() {
        // check if we need to resize backing array
        if (size >= threshold) {
            this.capacity *= 2;
            resize(this.capacity);
        }
    }

    /**
     * Put an item into the table. Handles resizing.
     */
    public void put(K key, V value) {
        checkForResize();
        addItem(buckets, key, value);
        size++;
    }

    /**
     * This method actually takes care of adding an item into the backing array and chain.
     */
    private void addItem(ChainNode[] toBuckets, K key, V value) {
        int idx = hash(key);
        for (ChainNode c = toBuckets[idx]; c != null; c = c.next) {
            if (c.key.equals(key)) {
                c.value = value;
                return;
            }
        }

        ChainNode n = new ChainNode(key, value);
        n.next = toBuckets[idx];
        toBuckets[idx] = n;
    }

    /**
     * Get a value by key. NULL if key not present.
     */
    public V get (K key) {
        int idx = hash(key);
        for (ChainNode c = buckets[idx]; c != null; c = c.next) {
            if (c.key.equals(key)) {
                return c.value;
            }
        }

        return null;
    }

    /**
     * Computes a key's hash.
     */
    private int hash(K key) {
        // ensure hashcode is positive and in bounds 0 to (capacity-1)
        return (key.hashCode() & 0x7fffffff) % this.capacity;
    }
}
