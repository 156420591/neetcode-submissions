class TimeMap {

    //using java HashMap way

    HashMap<String, Node> map = null;
    static class Node{
        String key;
        String value;
        int timestamp;
        Node next;

        public Node(String key, String value, int timestamp){
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
            this.next = null;
        }
    }
    public TimeMap() {
        this.map = new HashMap(512);
    }
    
    public void set(String key, String value, int timestamp) {
        Node newnode = new Node(key, value, timestamp);
        Node head = this.map.get(key);
        if(head != null){
            newnode.next = head;
        }
        this.map.put(key, newnode);
    }
    
    public String get(String key, int timestamp) {
        Node head = this.map.get(key);
        String res = "";
        while(head != null){
            Node next = head.next;
            if(timestamp >= head.timestamp){
                res = head.value;
                break;
            }
            head = next;
        }
        return res;

    }
}
