class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k + 1;
        this.minHeap = new PriorityQueue<>(k + 2);

        for (int num : nums)
            this.add(num);
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() == k)
            minHeap.poll();
        return minHeap.peek();
    }
}
