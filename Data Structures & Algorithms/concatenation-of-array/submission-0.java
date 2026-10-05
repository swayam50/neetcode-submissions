class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = Arrays.copyOf(nums, nums.length << 1);
        for (int i = 0, j = nums.length; i < nums.length; i++, j++)
            res[j] = res[i];
        return res;
    }
}