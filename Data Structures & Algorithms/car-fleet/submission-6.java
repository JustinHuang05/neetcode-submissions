class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pairs, (a, b) -> {
            return b[0] - a[0];
        });

        Deque<Double> timeStack = new ArrayDeque<>();
        for (int i = 0; i < pairs.length; i++) {
            double timeToTarget = ((double) target - (double) pairs[i][0]) / (double) pairs[i][1];

            if (timeStack.isEmpty()) {
                timeStack.push(timeToTarget);
                continue;
            }

            if (timeToTarget > timeStack.peek()) {
                timeStack.push(timeToTarget);
            }
        }

        return timeStack.size();
    }
}




