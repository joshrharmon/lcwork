class MedianFinder {
	
	// minHeap stores the higher half of numbers
	// maxHeap stores the lower half of numbers
	private PriorityQueue<Integer> minHeap, maxHeap;
	
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
		
		minHeap.offer(maxHeap.peek());
		maxHeap.poll();
		
		if(minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.peek());
			minHeap.poll();
		}
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		}
		else {
			return (((double)maxHeap.peek() + minHeap.peek())/2);
		}
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */