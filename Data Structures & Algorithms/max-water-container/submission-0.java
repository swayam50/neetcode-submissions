class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;

        int maxWater = 0;
        while (i < j) {
            int width = j - i;
            int height = heights[i] < heights[j] ? heights[i++] : heights[j--];

            int water = width * height;
            if (water > maxWater)
                maxWater = water;
        }

        return maxWater;
    }
}
