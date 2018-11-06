package practice.problems.arrays;

/**
 * Created by yashraj on 10/27/18.
 */
public class MyHashMap {
    private static final int SIZE = 32;

    private Entry[] table;

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(String key, String value) {
        Entry entry = new Entry(key, value);
        int code = key.hashCode() % SIZE;
        if(table[code] == null) {
            table[code] = entry;
        } else {
            addOrUpdateNode(table[code], entry);
        }
    }

    public String get(String key) {
        if (key == null) {
            return null;
        }
        int code = key.hashCode() % SIZE;
        Entry head = table[code];
        while(head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }


    public void remove(String key) {
        if (key == null) {
            return;
        }
        int code = key.hashCode() % SIZE;
        Entry head = table[code];
        Entry dummy = new Entry("0", "0");
        dummy.next = head;
        Entry prev = dummy;
        while (head != null) {
            if (head.key.equals(key)) {
                prev.next = head.next;
                table[code] = dummy.next;
                return;
            }
            prev = head;
            head = head.next;
        }

    }

    public boolean containsKey(String key) {
        int code = key.hashCode() % SIZE;
        Entry head = table[code];
        while (head != null) {
            if (head.key.equals(key)) return true;
            head = head.next;
        }
        return false;
    }

    private void addOrUpdateNode(Entry head, Entry node) {
        Entry prev = head;
        while (head != null) {
            if (head.key.equals(node.key)) {
                head.value = node.value;
                return;
            }
            prev = head;
            head = head.next;
        }
        prev.next = node;
    }
    public class Entry {
        String key, value;
        Entry next;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("1", "1");
        myHashMap.put("2", "2");
        myHashMap.put("3", "3");
        System.out.println(myHashMap.get("1"));

        System.out.println(myHashMap.containsKey("3"));
        System.out.println(myHashMap.containsKey("4"));

        myHashMap.put("1", "10");
        System.out.println(myHashMap.get("1"));

        myHashMap.remove("1");
        System.out.println(myHashMap.get("1"));

        myHashMap.remove("3");
        System.out.println(myHashMap.get("3"));
    }

}
