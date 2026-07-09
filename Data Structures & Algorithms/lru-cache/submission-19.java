class LRUCache {

    class DLNode {
        Integer key;
        Integer val;
        DLNode next;
        DLNode prev;

        public DLNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public DLNode() {
            this.key = null;
            this.val = null;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity;
    private Map<Integer, DLNode> map = new HashMap<>();
    private DLNode headNode;
    private DLNode tailNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        headNode = new DLNode();
        tailNode = new DLNode();
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DLNode foundNode = map.get(key);
            foundNode.prev.next = foundNode.next;
            foundNode.next.prev = foundNode.prev;

            tailNode.prev.next = foundNode;
            foundNode.prev = tailNode.prev;
            tailNode.prev = foundNode;
            foundNode.next = tailNode;
            return map.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLNode foundNode = map.get(key);
            foundNode.val = value;

            foundNode.prev.next = foundNode.next;
            foundNode.next.prev = foundNode.prev;

            tailNode.prev.next = foundNode;
            foundNode.prev = tailNode.prev;
            tailNode.prev = foundNode;
            foundNode.next = tailNode;
        } else {
            DLNode newNode = new DLNode(key, value);

            tailNode.prev.next = newNode;
            newNode.prev = tailNode.prev;
            tailNode.prev = newNode;
            newNode.next = tailNode;

            map.put(key, newNode);

            if (map.size() > capacity) {
                DLNode toRemove = headNode.next;
                headNode.next = headNode.next.next;
                headNode.next.prev = headNode;

                map.remove(toRemove.key);
            }
        }
    }
}
