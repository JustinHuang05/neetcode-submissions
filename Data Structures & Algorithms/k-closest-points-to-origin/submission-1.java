class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> { return
            Double.compare(Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2)), Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2)));
            });

        for (int i = 0; i < k; i++) {
            minHeap.add(points[i]);
        }

        for (int i = k; i < points.length; i++) {
            minHeap.add(points[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
