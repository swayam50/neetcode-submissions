class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minValue = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minValue)
                minValue = price;
            maxProfit = Math.max(maxProfit, price - minValue);
        }

        return maxProfit;
    }
}
