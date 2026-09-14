class Solution {
    public boolean hasDuplicate(int[] nums) {
        return new MySortMethod().hasDuplicate(nums);
    }
    static class MySortMethod{
        public boolean hasDuplicate(int[] nums) {
            if(nums.length <= 0){
                return false;
            }
            Arrays.sort(nums);
            int prev = nums[0];
            for(int i=1; i<nums.length; i++){
                if(prev == nums[i]){
                    return true;
                }
                prev = nums[i];
            }
            return false;
        }
    }
    static class MyArrayMapHeapOutOfMemory{
        public boolean hasDuplicate(int[] nums) {
            int[] positive = new int[1000000000+1];
            int[] negative = new int[1000000000];
            int index = 0;
            for(int i : nums){
                if(i < 0){
                    index = i * -1;
                    if( negative[index] > 0){
                        return true;
                    }
                    negative[index]++;
                }else{
                    index = i;
                    if( positive[index] > 0){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}