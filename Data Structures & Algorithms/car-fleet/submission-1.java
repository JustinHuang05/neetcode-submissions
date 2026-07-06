class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] posSpeedPairs = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            posSpeedPairs[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(posSpeedPairs, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < posSpeedPairs.length; i++) {
            Double time = (double) (target - posSpeedPairs[i][0]) / posSpeedPairs[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            } 
        }

        return stack.size();

    }
}
