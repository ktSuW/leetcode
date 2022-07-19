/*


*/
class LRUCache {

    // Create head and tail two nodes with dummy values 
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();
    int cacheCapacity;
    public LRUCache(int capacity) {
        cacheCapacity = capacity;
        //Connect head and tail
        // head -> tail
        //      <-
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            // Since we have accessed this node, this node becomes most recently used 
            // Therefore, we need to move it
            remove(node);
            // After removing it, add it the LRU side
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        // Remove least recently used cache 
        if(map.size() == cacheCapacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    

    
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // head ->  new
    //      <-  
    private void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.prev = head;
        headNext.prev = node;
    }
        // This node will act as doubly linked list 
    class Node {
        Node prev;
        Node next;
        int key, value;
        Node(int _key, int _value){
            key = _key;
            value = _value;
        }
    }
    

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */