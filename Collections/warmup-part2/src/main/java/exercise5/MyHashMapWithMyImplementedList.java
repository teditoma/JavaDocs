package exercise5;

import exercise4.MyHashMap;

import java.util.*;

/**
 * Create a HashMap that uses to store the buckets your implementation of MyImplementedList that you
 * created in the Collections I workshop.
 *
 * Created by Radu.Hoaghe on 7/6/2017.
 */
public class MyHashMapWithMyImplementedList {

    // TODO uncomment the following line and add your MyImplementedList implementation to the project
    private MyImplementedList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMapWithMyImplementedList() {
        // TODO
        buckets = new MyImplementedList<LinkedList<MyEntry>>();
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

    public Set<MyHashMap.MyEntry> entrySet() {
        // TODO Return a Set containing all the Entry objects
        return null;
    }

    public boolean isEmpty() {
        // TODO
        for (LinkedList<MyEntry> list : buckets)
            if (!list.isEmpty())
                return false;
        return true;
    }

    public static class MyEntry {
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

        public void setValue(String value) {
            this.value = value;
        }
    }
}
