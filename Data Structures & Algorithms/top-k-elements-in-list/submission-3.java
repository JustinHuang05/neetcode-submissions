class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<int[]> array = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array.add(new int[]{entry.getKey(), entry.getValue()});
        }
        array.sort((a, b) -> b[1] - a[1]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = array.get(i)[0];
        }

        return result;
    }
}
