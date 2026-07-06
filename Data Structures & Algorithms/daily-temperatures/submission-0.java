class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int peekVal = stack.pop();
                result[peekVal] = i - peekVal;
            };
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }
}
