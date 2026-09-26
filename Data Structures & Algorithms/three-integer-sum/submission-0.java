class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2;) {
            int num = nums[k];

            if (num > 0)
                break;

            int target = num * -1;
            for (int i = k + 1, j = nums.length - 1; i < j;) {
                int left = nums[i], right = nums[j];
                if (left + right < target) {
                    while (i < j && nums[i] == left)
                        i++;
                } else if (left + right > target) {
                    while (i < j && nums[j] == right)
                        j--;
                } else {
                    res.add(List.of(num, left, right));
                    while (i < j && nums[i] == left)
                        i++;
                    while (i < j && nums[j] == right)
                        j--;
                }
            }

            while (k < nums.length - 2 && nums[k] == num)
                k++;
        }

        return res;
    }
}
