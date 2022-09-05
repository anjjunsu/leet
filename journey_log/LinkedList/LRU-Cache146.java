import java.util.HashMap;
import java.util.Map;

// Use Map to keep track of key and value
// Use doubly linked list to track LRU

class LRUCache {

    class DLinkedNode {

        DLinkedNode prev;
        DLinkedNode next;
        int key;
        int value;
    }

    private DLinkedNode head;
    private DLinkedNode tail;
    private int capacity;
    private int size;
    private Map<Integer, DLinkedNode> cache;

    public LRUCache(int capacity) {
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        
        if (node == null)
            return -1;
            
        touchNode(node);

        return node.value;
    }   
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            insertNodeAtFirst(newNode);
            
            size++;

            if (size > capacity) {
                DLinkedNode toDelete = getLRUNode();
                cache.remove(toDelete.key);
                size--;
            }
        } else {
            node.value = value;
            touchNode(node);
        }
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insertNodeAtFirst(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
    
    private DLinkedNode getLRUNode() {
        DLinkedNode result = tail.prev;
        removeNode(result);

        return result;
    }

    private void touchNode(DLinkedNode node) {
        removeNode(node);  
        insertNodeAtFirst(node);   
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */