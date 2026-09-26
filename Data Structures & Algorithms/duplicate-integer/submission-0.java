class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> duplicates = new HashSet<>();
        for (int num : nums)
            if (!duplicates.add(num))
                return true;
        return false;
    }
}