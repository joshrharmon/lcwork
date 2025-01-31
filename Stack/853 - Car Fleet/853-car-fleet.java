class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
		TreeMap<Integer, Integer> cars = new TreeMap<>(Collections.reverseOrder());
		int fleets = 0; 
        double slowest = 0.0;
		for(int i = 0; i < position.length; ++i) {
			cars.put(position[i], speed[i]);
		}
        for(Map.Entry<Integer, Integer> entry : cars.entrySet()) {
        	double time = (double)(target - entry.getKey())/entry.getValue();
        	if(time <= slowest) {
        		continue;
        	}
        	++fleets;
        	slowest = time;
        }
        return fleets;
    }
}
