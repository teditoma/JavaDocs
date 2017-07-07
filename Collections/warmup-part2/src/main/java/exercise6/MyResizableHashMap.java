package exercise6;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Create a resizable generic HashMap. When the number of entries exceeds (load capacity * bucket array size)
 * the HashMap needs to be resized.
 *
 * Resizing (rehashing) consists in increasing the size of the bucket array with the value of
 * INCREASE_SIZE_FACTOR. After this step, all the entries that were stored in the HashMap
 * must be inserted in the new bucket array according to the insertion algorithm in a HashMap:
 * the entry must be placed in a bucket after applying the hash function (hashcode modulo (bucket array size))
 * on the key's hashcode value. The result of the hash function will return the index from the
 * bucket array where the entry will be stored. (see HashMap documentation)
 *
 * Created by Radu.Hoaghe on 7/6/2017.
 */
public class MyResizableHashMap<K, V> {

    /**
     * The array of buckets.
     */
    private Node<K, V>[] buckets;

    /**
     * Default initial capacity for the bucket array.
     */
    private final int DEFAULT_BUCKET_ARRAY_SIZE = 16;

    /**
     * The maximum accepted load property of the data structure.
     */
    private static final double LOAD_FACTOR = 0.75d;

    /**
     * The factor for increasing the size of the data structure.
     */
    private static final int INCREASE_SIZE_FACTOR = 2;

    /**
     * The number of entries stored in the Map.
     */
    private int size;

    /**
     * The current maximum capacity of the map
     */
    private int currentMaxCapacity;

    public MyResizableHashMap() {

        // TODO Initialize buckets list
        buckets = new Node[DEFAULT_BUCKET_ARRAY_SIZE];
        size = 0;
        currentMaxCapacity = DEFAULT_BUCKET_ARRAY_SIZE;
    }

    private void resize() {
        // TODO function that does the rehashing of the HashMap
        int nextMaxCapacity = currentMaxCapacity * INCREASE_SIZE_FACTOR;
        Node<K,V>[] auxBuckets = new Node[nextMaxCapacity];
        for (int i = 0; i < currentMaxCapacity; i++) {
            Node<K,V> node = buckets[i];
            while(node != null) {
                MyEntry<K,V> entry = node.getEntry();

                // Compute new hash
                int hash = hash(entry.getKey(),nextMaxCapacity);
                Node<K,V> auxNode = auxBuckets[hash];

                // If bucket is empty
                if (auxNode == null) {
                    auxNode = new Node<K, V>(new MyEntry<K, V>(entry.getKey(), entry.getValue()), hash, null);
                    auxBuckets[hash] = auxNode;
                }
                else {
                    // Go to last element and insert there
                    while (auxNode.getNextElement() != null) {
                        auxNode = auxNode.getNextElement();
                    }
                    auxNode.setNextElement(new Node<K, V>(new MyEntry<K, V>(entry.getKey(), entry.getValue()), hash, null));
                }
                node = node.getNextElement();
            }
        }
        buckets = auxBuckets;
        currentMaxCapacity = nextMaxCapacity;
    }

    private int hash(K key, int size){
        if (key == null)
            return 0;
        return Math.abs(key.hashCode() % size);
    }

    public V get(K key) {
        // TODO
        int hash = hash(key, currentMaxCapacity);
        Node<K,V> node = buckets[hash];
        while (node != null) {
            if (node.getEntry().getKey() == null && key == null)
                return node.getEntry().getValue();
            if (node.getEntry().getKey().equals(key))
                return node.getEntry().getValue();
            node = node.getNextElement();
        }
        return null;
    }

    public void put(K key, V value) {
        // TODO
        int hash = hash(key, currentMaxCapacity);
        if (size + 1 > currentMaxCapacity * LOAD_FACTOR)
            resize();

        Node<K,V> node = buckets[hash];
        if (node == null) {
            node = new Node<K, V>(new MyEntry<K, V>(key, value), hash, null);
            buckets[hash] = node;
            size++;
            return;
        }
        while (node.getNextElement() != null) {
            if (node.getEntry().getKey() == null && key == null) {
                node.getEntry().setValue(value);
                return;
            }
            if (node.getEntry().getKey().equals(key)) {
                node.getEntry().setValue(value);
                return;
            }
            node = node.getNextElement();
        }
        if (node.getEntry().getKey().equals(key)) {
            node.getEntry().setValue(value);
            return;
        }
        if (node.getEntry().getKey() == null && key == null) {
            node.getEntry().setValue(value);
            return;
        }
        node.setNextElement(new Node<K, V>(new MyEntry<K, V>(key, value), hash, null));
        size++;
    }

    public String toString() {
        String print = "[";
        for (int i = 0; i < size; i++) {
            Node<K,V> node = buckets[i];
            while(node != null) {
                print += node.getEntry().getKey() + " ";
                node = node.getNextElement();
            }
        }
        print += "]";
        return print;
    }
    public Set<K> keySet() {
        // TODO
        Set<K> keySet = new HashSet<K>();
        for (Node<K, V> node : buckets) {
            while (node != null) {
                keySet.add(node.getEntry().getKey());
                node = node.getNextElement();
            }
        }
        return keySet;
    }

    public Collection<V> values() {
        // TODO
        Set<V> values = new HashSet<V>();
        for (Node<K, V> node : buckets) {
            while (node != null) {
                values.add(node.getEntry().getValue());
                node = node.getNextElement();
            }
        }
        return values;
    }

    public V remove(K key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        int hash = hash(key, currentMaxCapacity);
        Node<K,V> node = buckets[hash];

        if (node == null)
            return null;

        if (node.getEntry().getKey().equals(key)) {
            V value = node.getEntry().getValue();
            buckets[hash] = node.getNextElement();
            size--;
            return value;
        }
        while (node.getNextElement()!= null) {
            if (key.equals(node.getNextElement().getEntry().getKey())) {
                V value = node.getNextElement().getEntry().getValue();
                node.setNextElement(node.getNextElement().getNextElement());
                size--;
                return value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        // TODO
        int hash = hash(key,currentMaxCapacity);
        Node<K,V> node = buckets[hash];
        while (node != null) {
            if (key.equals(node.getEntry().getKey()))
                return true;
            node = node.getNextElement();
        }
        return false;
    }

    public boolean containsValue(V value) {
        // TODO
        for (int i = 0; i < currentMaxCapacity; i++ ) {
            Node<K,V> node = buckets[i];
            while (node != null) {
                if (node.getEntry().getValue().equals(value))
                    return  true;
                node = node.getNextElement();
            }
        }
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        return size;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        for (int i = 0; i < currentMaxCapacity; i++ ) {
            buckets[i] = null;
        }
        size = 0;
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        Set<MyEntry> set = new HashSet<MyEntry>();
        for (int i = 0; i < currentMaxCapacity; i++ ) {
            Node<K,V> node = buckets[i];
            while (node != null) {
                set.add(node.getEntry());
                node = node.getNextElement();
            }
        }
        return set;
    }

    public boolean isEmpty() {
        // TODO
        for (int i = 0; i < currentMaxCapacity; i++ ) {
            if (buckets[i] != null)
                return false;
        }
        return true;
    }

    public static class MyEntry<K, V> {
        private K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    static class Node<K, V> {
        private final MyEntry<K, V> entry;
        private final int hash;
        private Node<K, V> nextElement;

        public Node(MyEntry<K, V> entry, int hash, Node<K, V> nextElement) {
            this.entry = entry;
            this.hash = hash;
            this.nextElement = nextElement;
        }

        public MyEntry<K, V> getEntry() {
            return entry;
        }

        public int getHash() {
            return hash;
        }

        public Node<K, V> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<K, V> nextElement) {
            this.nextElement = nextElement;
        }

    }
}
