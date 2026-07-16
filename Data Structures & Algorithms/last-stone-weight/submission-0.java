class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int max = maxHeap.poll();
            int secondMax = maxHeap.poll();
            if (max > secondMax) {
                maxHeap.add(max - secondMax);
            } 
        }

        if (maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.peek();
        }
    }
}
