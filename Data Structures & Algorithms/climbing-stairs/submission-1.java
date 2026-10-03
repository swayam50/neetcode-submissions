class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int a = 2, b = 1;
        n -= 2;

        while (n-- > 0) {
            int temp = a + b;
            b = a;
            a = temp;
        }

        return a;
    }
}
