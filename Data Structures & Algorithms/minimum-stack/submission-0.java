class MinStack {
    private List<Integer> stack = new LinkedList<>();
    private List<Integer> minEles = new LinkedList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.addLast(val);
        if (minEles.isEmpty() || val < minEles.getLast())
            minEles.addLast(val);
        else
            minEles.addLast(minEles.getLast());
    }
    
    public void pop() {
        stack.removeLast();
        minEles.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minEles.getLast();
    }
}
