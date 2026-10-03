class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> nextGreaterEles = new Stack<>();
        
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!nextGreaterEles.empty() && temperatures[nextGreaterEles.peek()] <= temperatures[i])
                nextGreaterEles.pop();
            res[i] = nextGreaterEles.empty() ? 0 : nextGreaterEles.peek() - i;
            nextGreaterEles.push(i);
        }

        return res;
    }
}
