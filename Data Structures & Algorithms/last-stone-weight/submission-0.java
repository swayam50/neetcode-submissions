class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, (e1, e2) -> e2 - e1);
        for (int stone : stones)
            maxHeap.offer(stone);

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 != stone2)
                maxHeap.offer(stone1 - stone2);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
