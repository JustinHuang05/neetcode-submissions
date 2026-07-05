class MinStack {

    Stack<Integer> vals;
    Stack<Integer> mins;

    public MinStack() {
        vals = new Stack<Integer>();
        mins = new Stack<Integer>();
    }
    
    public void push(int val) {
        vals.push(val);
        if (mins.isEmpty()) {
            mins.push(val);
        } else {
            if (val <= mins.peek()) {
                mins.push(val);
            }
        }
    }
    
    public void pop() {
        System.out.println(mins.peek());
        System.out.println(vals.peek());
        if (mins.peek().equals(vals.peek())) {
            System.out.println("equal");
            mins.pop();
        }
        vals.pop();
    }
    
    public int top() {
        return vals.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
