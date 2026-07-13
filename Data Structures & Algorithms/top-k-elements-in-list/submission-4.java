class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freqBuckets = new List[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < freqBuckets.length; i++) {
            freqBuckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freqBuckets[entry.getValue() - 1].add(entry.getKey());
        }

        int[] result = new int[k];

        int curResIdx = 0;
        for (int i = freqBuckets.length - 1; i >= 0 && curResIdx < k; i--) {
            for (Integer num : freqBuckets[i]) {
                if (curResIdx < k) {
                    result[curResIdx] = num;
                    curResIdx++;
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
