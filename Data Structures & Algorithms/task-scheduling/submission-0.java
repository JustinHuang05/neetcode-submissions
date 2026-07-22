class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        Deque<int[]> q = new ArrayDeque<>();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        for (int val : map.values()) {
            maxHeap.add(val);
        }

        int cycle = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            if (!q.isEmpty() && cycle >= q.peek()[1]) {
                maxHeap.add(q.poll()[0]);
            }

            if (!maxHeap.isEmpty()) {
                int current = maxHeap.poll();
                current--;
                if (current > 0) {
                    q.add(new int[]{current, cycle + n + 1});
                }
            }

            cycle++;
        }

        return cycle;
    }
}
