class Solution {
    public int[] productExceptSelf(int[] nums) {
        long total = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0)
                zeroCount++;
            else 
                total *= num;
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (zeroCount > 1) {
                res[i] = 0;
                continue;
            } else if (zeroCount == 1)
                res[i] = (nums[i] == 0) ? (int)total : 0;
            else
                res[i] = (int)(total / (long)nums[i]);
        }

        return res;
    }
}  
