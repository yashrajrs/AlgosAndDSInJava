package practice.otherProblems;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.

 * get(key) - Get the value (will always be positive) of the key
 * if the key exists in the cache, otherwise return -1.
 *set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * @author Yashraj R. Sontakke
 */
public class LRUCache {
    private int capacity;
    private int size = 0;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node first, last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.get(key) != null){
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(map.get(key) != null){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            add(node);
        }else{
            Node node = new Node(key, value);
            if(size < capacity){
                add(node);
                map.put(key, node);
                size++;
            }else{
                map.remove(first.key);
                first = first.next;
                if(first !=null){
                    first.prev = null;
                }
                add(node);
                map.put(key,node);
            }
        }
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        node.prev = null;
        node.next = null;
        if(prev!=null){
            prev.next = next;
        }else{
            first = next;
        }
        if(next !=null){
            next.prev = prev;
        }else{
            last = prev;
        }
    }

    public void add(Node node){
        if(last==null){
            last = node;
            first = node;
        }else{
            node.prev = last;
            last.next = node;
            last = node;
        }
    }

    public class Node{
        int key, value;
        Node prev, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }



    public static void main(String[] args){
        LRUCache cache = new LRUCache(4);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        cache.printCache();
        cache.get(2);
        cache.get(3);

        cache.printCache();
        cache.set(5,5);
        cache.printCache();
        cache.set(6,6);
        cache.printCache();
        cache.set(3,9);
        cache.printCache();
    }

    public void printCache(){
        Node node = first;
        while(node != null){
            System.out.print(String.format("{%d,%d} ",node.key, node.value));
            node = node.next;
        }
        System.out.println();
    }
}
