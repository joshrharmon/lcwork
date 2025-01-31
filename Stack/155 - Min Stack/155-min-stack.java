class MinStack {
	
	private Stack<Integer> s;
	private Stack<int[]> mins;

    public MinStack() {
        s = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int val) {
    	s.push(val);
    	if(mins.isEmpty() || val < mins.peek()[0]) {
	    	mins.push(new int[]{val, 1});
    	}
    	else if(val == mins.peek()[0]) {
    		mins.peek()[1]++;
    	}
    }
    
    public void pop() {
    	if(!mins.isEmpty() && s.peek().equals(mins.peek()[0])) {
    		if(mins.peek()[1] == 1) {
    			mins.pop();
    		} else {
    			mins.peek()[1]--;
    		}
    	}
    	s.pop();
    }
    
    public int top() {
    	return s.peek();
    }
    
    public int getMin() {
    	return mins.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
