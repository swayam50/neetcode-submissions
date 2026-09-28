class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int num : nums)
            uniques.add(num);

        int maxLen = 0;
        for (int num : nums)
            if (uniques.contains(num)) {
                int len = 1;
                uniques.remove(num);
                
                for (int temp = num - 1; uniques.contains(temp); temp--) {
                    len++;
                    uniques.remove(temp);
                }

                for (int temp = num + 1; uniques.contains(temp); temp++) {
                    len++;
                    uniques.remove(temp);
                }

                if (len > maxLen)
                    maxLen = len;
            }

        return maxLen;
    }
}
