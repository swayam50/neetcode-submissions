class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] leftProduct = new int[n], rightProduct = new int[n];

        leftProduct[0] = nums[0];
        for (int i = 1; i < n; i++)
            leftProduct[i] = leftProduct[i-1] * nums[i];
    
        rightProduct[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--)
            rightProduct[i] = rightProduct[i+1] * nums[i];

        int[] res = new int[n];
        res[0] =  rightProduct[1];
        res[n-1] = leftProduct[n-2];
        for (int i = 1; i < n - 1; i++)
            res[i] = leftProduct[i-1] * rightProduct[i+1];
    
        return res;
    }
}  
