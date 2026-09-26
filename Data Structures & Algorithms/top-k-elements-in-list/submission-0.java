class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums)
            freqs.merge(num, 1, Math::addExact);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        int[] vals = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : minHeap)
            vals[i++] = entry.getKey();
        return vals;
    }
}
