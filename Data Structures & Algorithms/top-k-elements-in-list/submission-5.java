class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int key : map.keySet()) {
            buckets[map.get(key) - 1].add(key);
        }

        int[] result = new int[k];
        int currentResIdx = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = 0; j < buckets[i].size(); j++) {
                result[currentResIdx] = buckets[i].get(j);
                currentResIdx++;
                if (currentResIdx >= result.length) {
                    return result;
                }
            }
        }

        return new int[0];
    }
}
