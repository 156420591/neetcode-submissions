class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return new ArrayMap().topKFrequent(nums, k);
    }
    static class MySortMethod{
        public int[] topKFrequent(int[] nums, int k) {
            Arrays.sort(nums);
            final int len = nums.length;
            int now;
            for(int i=0; i<len; i++){
                now = nums[i];


            }
            return null;
        }
    }
    static class Link{
        int val;
        Link next;
        Link(int val){
            next = null;
            this.val = val;
        }
    }
    static class ArrayMap{
        public int[] topKFrequent(int[] nums, int k) {
            int[] map = new int[2001];
            final int BASE = 1000;
            for(int i : nums){
                map[i + BASE]++;
            }
            Link[] countmap = new Link[10000];
            int count = 0, value = 0;
            for(int i=0; i<map.length; i++){
                count = map[i];
                if(count <= 0){
                    continue;
                }
                value = i - BASE;

                Link newnode = new Link(value);
                Link head = countmap[count];
                
                if(head != null){
                    newnode.next = head;
                }
                countmap[count] = newnode;
            }
            int[] res = new int[k];
            int curidx = k-1;
            outloop:
            for(int i=countmap.length-1; i>=0; i--){
                Link head = countmap[i];
                if(head == null){
                    continue;
                }
                if(curidx < 0){
                    break outloop;
                }
                Link next = head;
                while(next != null){
                    res[curidx] = next.val;
                    curidx--;
                    if(curidx < 0){
                        break outloop;
                    }
                    next = next.next;
                }

            }
            return res;
        }
    }
}
