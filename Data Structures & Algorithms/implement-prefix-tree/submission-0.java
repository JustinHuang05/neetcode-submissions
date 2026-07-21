class PrefixTree {

    class Node {
        public Map<Character, Node> map = new HashMap();
        public Character val;
        public Boolean isEnd = false;

        public Node() {}

        public Node(Character val) {
            this.val = val;
        }
    }

    Node head = new Node();

    public PrefixTree() {}

    public void insert(String word) {
        Node pointer = head;
        for (int i = 0; i < word.length(); i++) {
            if (pointer.map.containsKey(word.charAt(i))) {
                pointer = pointer.map.get(word.charAt(i));
            } else {
                pointer.map.put(word.charAt(i), new Node(word.charAt(i)));
                pointer = pointer.map.get(word.charAt(i));
            }
        }
        pointer.isEnd = true;
    }

    public boolean search(String word) {
        Node pointer = head;
        for (int i = 0; i < word.length(); i++) {
            if (pointer.map.containsKey(word.charAt(i))) {
                pointer = pointer.map.get(word.charAt(i));
            } else {
                return false;
            }
        }

        if (pointer.isEnd) {
            return true;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        Node pointer = head;
        for (int i = 0; i < prefix.length(); i++) {
            if (pointer.map.containsKey(prefix.charAt(i))) {
                pointer = pointer.map.get(prefix.charAt(i));
            } else {
                return false;
            }
        }

        return true;
    }
}
