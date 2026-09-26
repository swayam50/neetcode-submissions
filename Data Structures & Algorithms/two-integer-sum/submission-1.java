class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            if (numsIndices.containsKey(target - nums[i]))
                return new int[] {numsIndices.get(target - nums[i]), i};
            else
                numsIndices.putIfAbsent(nums[i], i);
        return null;
    }
}
