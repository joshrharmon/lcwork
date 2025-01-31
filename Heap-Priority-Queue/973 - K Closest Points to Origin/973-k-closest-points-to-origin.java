/* 
 * Possible optimization: Use TreeMap and trim size to K
 */
public class closestComparator implements Comparator<Pair<int[], Double>> {
    @Override
    public int compare(Pair<int[], Double> p1, Pair<int[], Double> p2) {
        if (p1.getValue() > p2.getValue()) {
            return 1;
        } else if (p1.getValue() < p2.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<int[], Double>> closest = new PriorityQueue<Pair<int[], Double>>(new closestComparator());

        int[][] numClosest = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            closest.add(new Pair<>(points[i], dist(points[i][0], points[i][1])));
        }

        for (int i = 0; i < k; i++) {
            Pair<int[], Double> temp = closest.poll();
            numClosest[i] = temp.getKey();
        }
        return numClosest;
    }

    public double dist(double x, double y) {
        return Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
    }
}