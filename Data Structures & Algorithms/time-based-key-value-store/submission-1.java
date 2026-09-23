class TimeMap {
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
    Node[] map = null;
    final int CAP = 1000;

    public TimeMap() {
        this.map = new Node[CAP];
    }
    int hashcode(String key){
        char[] arr = key.toCharArray();
        int code = 0;
        for(int i=0; i<arr.length; i++){
            code += i + arr[i];
        }
        return code % CAP;
    }
    
    public void set(String key, String value, int timestamp) {
        Node newnode = new Node(key, value, timestamp);
        int code = hashcode(key);
        Node head = this.map[code];
        if(head != null){
            newnode.next = head;
        }
        this.map[code] = newnode;
    }
    
    public String get(String key, int timestamp) {
        int idx = hashcode(key);
        Node head = this.map[idx];
        if(head == null){
            return "";
        }
        String res = "";
        while(head != null){
            Node next = head.next;
            if(key.compareTo(head.key) == 0 && timestamp >= head.timestamp ){
                res = head.value;
                break;
            }
            head = next;
        }
        return res;
    }
}



















