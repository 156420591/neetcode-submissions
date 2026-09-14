class Solution {
    public int longestConsecutive(int[] nums) {
        return new MySortWay().longestConsecutive(nums);
    }
    static class MySortWay{
        public int longestConsecutive(int[] nums) {
            if(nums.length <= 0){
                return 0;
            }
            if(nums.length == 1) return 1;
            Arrays.sort(nums);
            int max = 1, cnt = 1;
            
            int now;
            int[] uniq = new int[nums.length];
            uniq[0] =nums[0];
            int nowidx = 0;
            int prev = nums[0];
            for(int i=1; i<nums.length; i++){
                now = nums[i];
                if(now == prev){
                    continue;
                }
                ++nowidx;
                uniq[nowidx] = now;
                prev = now;
            }
            prev = uniq[0];
            for(int i=1; i<=nowidx; i++){
                now = uniq[i];
                if(now != prev + 1 ){
                    if(cnt > max){
                        max = cnt;
                    }
                    cnt = 1;
                }else{
                    cnt++;
                }
                prev = now;
            }
            if(cnt > max){
                max = cnt;
            }
            return max;
        }
    }
}
