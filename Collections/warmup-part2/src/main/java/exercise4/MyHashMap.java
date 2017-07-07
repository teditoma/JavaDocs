package exercise4;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {

        // TODO Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>(BUCKET_ARRAY_SIZE);
        for (int i = 0; i < BUCKET_ARRAY_SIZE; i++)
            buckets.add(new LinkedList<MyEntry>());
    }

    private int hash(String key){
        if (key == null)
            return 0;
        return Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
    }

    public String get(String key) {
        // TODO
        int hash = hash(key);
        for (MyEntry entry : buckets.get(hash)) {
            if (key == null && entry.getKey() == null)
                return entry.getValue();
            if (entry.getKey().equals(key))
                return entry.getValue();
        }
        return null;
    }

    public void put(String key, String value) {
        // TODO

        int hash = hash(key);
        for (MyEntry entry : buckets.get(hash)) {
            if (value == null && entry.getKey() == null) {
                    entry.setValue(value);
                    return;
                }
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        buckets.get(hash).add(new MyEntry(key,value));
    }

    public Set<String> keySet() {
        // TODO
        Set<String> keys = new HashSet<String>();
        for ( LinkedList<MyEntry> bucket : buckets)
            for ( MyEntry entry : bucket)
                keys.add(entry.getKey());

        return keys;
    }

    public Collection<String> values() {
        // TODO
        Collection<String> values = new ArrayList<String>();
        for (LinkedList<MyEntry> bucket : buckets)
            for (MyEntry entry : bucket)
                values.add(entry.getValue());

        return values;
    }

    public String remove(String key) {
        // TODO Returns the value associated with the key removed from the map or null if the key wasn't found
        int hash = hash(key);
        for (MyEntry entry : buckets.get(hash))
            if (entry.getKey().equals(key)) {
                buckets.get(hash).remove(entry);
                return entry.getValue();
            }
        return null;
    }

    public boolean containsKey(String key) {
        // TODO
        for (LinkedList<MyEntry> list : buckets)
            for (MyEntry entry : list)
                if (entry.getKey().equals(key))
                    return true;
        return false;
    }

    public boolean containsValue(String value) {
        // TODO
        for (LinkedList<MyEntry> list : buckets)
            for (MyEntry entry : list)
                if (entry.getValue().equals(value))
                    return true;
        return false;
    }

    public int size() {
        // TODO Return the number of the Entry objects stored in all the buckets
        int count = 0;
        for (LinkedList<MyEntry> list : buckets)
            for (MyEntry entry : list)
                count ++;
        return count;
    }

    public void clear() {
        // TODO Remove all the Entry objects from the bucket list
        for (LinkedList<MyEntry> list : buckets)
            list.clear();
    }

    public Set<MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        Set<MyEntry> set = new HashSet<MyEntry>();
        for (LinkedList<MyEntry> list : buckets)
            for (MyEntry entry : list)
                set.add(entry);
        System.out.println(set);

        return set;
    }

    public boolean isEmpty() {
        // TODO
        for (LinkedList<MyEntry> list : buckets)
            if (!list.isEmpty())
                return false;
        return true;
    }

    public static class MyEntry implements Map.Entry<String,String>{
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public String setValue(String value) {
            return null;
        }

//        public void setValue(String value) {
//            this.value = value;
//        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass())
                return false;
            MyEntry entry = (MyEntry)obj;
            if (!entry.getKey().equals(this.key)) return false;
            if (!entry.getValue().equals(this.value)) return false;

            return true;
        }
    }
}
