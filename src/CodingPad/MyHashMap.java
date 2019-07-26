//package CodingPad;
//
//import java.util.Arrays;
//
///*
//A hashtable implementation of map, demonstration purpose, generic type is provided.
//
//supported operations:
//    size()
//    isEmpty()
//    clear()
//    put(K key, V, value)
//    get(K, key)
//    containsKey(K key)
//    containsValue(V value)
//    remove(K, key)
// */
//public class MyHashMap {
//    public static class Node<K, V> {
//        final K key;
//        V value;
//        Node<K, V> next;
//        Node(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public K getKey() {
//            return this.key;
//        }
//
//        public V getValue() {
//            return this.value;
//        }
//
//        public V setValue(V value) {
//            this.value = value;
//            return this.value;
//        }
//
//        public Node<K, V> getNext() {
//            return this.next;
//        }
//    }
//
//
//    private Node<K, V>[] array;
//    private int size;
//    private int capacity;
//    private float loadFactor;
//
//    public MyHashMap(int cap, float loadFactor) {
//        if (cap <= 0) {
//            throw new IllegalArgumentException("cap can not be <= 0");
//        }
//
//        this.capacity = cap;
//        this.size = 0;
//        this.loadFactor = loadFactor;
//        this.array = (Node<K, V>[])(new Node[this.capacity]);
//    }
//
//
//
//    public int size() {
//        return this.size;
//    }
//
//    public boolean isEmpty() {
//        return this.size == 0;
//    }
//
//    public void clear() {
//        Arrays.fill(array, null);
//    }
//
//    public V put(K key, V value) {
//        int index = getIndex(key);
//        // prepare insert new element at list head
//        Node<K, V> head = array[index];
//        Node<K, V> node = head;
//        while (node != null) {
//            if (equalsKey(node.getKey(), key)) {
//                // update
//                V result = node.getValue();
//                node.setValue(value);
//                return result;
//            }
//            node = node.next;
//        }
//        // append new node before the head
//        Node<K, V> newNode = new Node(key, value);
//        newNode.next = head;
//        array[index] = newNode;
//        this.size++;
//        if (needRehashing()) {
//            rehashing();
//        }
//        return null;
//    }
//
//    public V get(K key) {
//        int index = getIndex(key);
//        Node<K, V> node = array[index];
//        while (node != null) {
//            if (equalsKey(head.key, key)) {
//                return node.value;
//            }
//        }
//        return null;
//    }
//
//    public boolean containsKey(K key) {
//        int index = getIndex(key);
//        Node<K, V> node = array[index];
//        while (node != null) {
//            if (equalsKey(node.getKey(), key)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean containsValue(V value) {
//        // special case
//        if (isEmpty()) {
//            return false;
//        }
//        for (Node node : array) {
//            if (equalsValue(node.getValue(), value)) {
//                return true;
//            }
//            node = node.next;
//        }
//        return false;
//    }
//
//    public V remove(K key) {
//        int index = getIndex(key);
//        Node<K, V> head = array[index];
//        if (head == null) {
//            return null;
//        }
//        Node<K, V> node = head.next;
//        while (node != null) {
//            if (equalsKey(node.getKey(), key)) {
//                head.next = node.next;
//                node.next = null;
//                return node.getValue();
//            }
//            node = node.next;
//            head = head.next;
//        }
//        return null;
//    }
//
//    private int hash(K key) {
//        // case_1: null key
//        if (key == null) {
//            return 0;
//        }
//        // case_2 hashCode()
//        return key.hashCode() & 0X7FFFFFF; // guarantee non-negative, java % is remainder not module
//    }
//
//    private int getIndex(K key) {
//        return hash(key) % this.capacity;
//    }
//
//    private boolean equalsKey(K k1, K k2) {
//        return k1 == k2 || (k1 != null && k1.equals(k2));
//    }
//
//    private boolean equalsValue(V v1, V v2) {
//        return v1 == v2 || (v1 != null && v1.equals(v2));
//    }
//
//    private boolean needRehashing() {
//        float curLoadFactor = (float)(this.size / this.capacity);
//        return curLoadFactor > this.loadFactor;
//    }
//
//    private void rehashing() {
//        this.capacity *= 2;
//        Node<K, V>[] oldArray = this.array;
//        this.array = (Node<K, V>[])(new Node[this.capacity]);
//        for (Node<K, V> node : oldArray) {
//            while (node != null) {
//                put(node.getKey(), node.getValue());
//                node = node.next;
//            }
//        }
//    }
//}
