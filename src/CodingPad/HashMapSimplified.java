package CodingPad;
/*
    supported operation:
        size()
        isEmpty()
        put(String key, Integer, value)
        get(String key)
 */

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Objects;

public class HashMapSimplified {
    private class Entry {
        private java.lang.String key;
        private Integer value;
        private Entry next;

        Entry(java.lang.String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public java.lang.String getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }

        public int setValue(int value) {
            this.value = value;
            return this.value;
        }
    }

    Entry[] buckets;
    int size;
    private int initialCapacity = 10;
    private int Capacity;

    public void HashMapSimplified() {
        this.buckets = new Entry[this.initialCapacity];
        this.size = 0;
        this.Capacity = this.initialCapacity;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Integer put(java.lang.String key, Integer value) {
        // search, update && insert
        int hash = key.hashCode();
        int index = hash % this.Capacity;

        Entry dummyHead = new Entry("", 0);
        dummyHead.next = this.buckets[index];
        while (dummyHead.next != null) {
            if (dummyHead.next == null) {
                dummyHead.next = new Entry(key, value);
                this.size++;
                return dummyHead.next.getValue();
            } else if (dummyHead.next.getKey().equals(key)) {
                // find target entry
                dummyHead.next.setValue(value);
                return dummyHead.next.getValue();
            }
            dummyHead = dummyHead.next;
        }
        return null;
    }

    public Integer get(String key) {
        // search, return result
        int hash = key.hashCode();
        int index = hash % this.Capacity;

        Entry dummyHead = new Entry("", 0);
        dummyHead.next = this.buckets[index];
        while (dummyHead.next != null) {
            if (dummyHead.next.getKey().equals(key)) {
                // find target entry
                return dummyHead.next.getValue();
            }
            dummyHead = dummyHead.next;
        }
        return null;
    }

    private void augment() {

    }

    private void reHash() {

    }
}
