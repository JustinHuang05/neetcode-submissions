class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        ArrayList<Integer>[] freqBuck = new ArrayList[nums.length];

        for (int i = 0; i < nums.length; i++) {
            freqBuck[i] = new ArrayList<Integer>();
        }

        for (int key : map.keySet()) {
            freqBuck[map.get(key) - 1].add(key);
        }
                
        int[] result = new int[k];
        int curIndex = 0;

        System.out.println(map);
        for (ArrayList<Integer> list : freqBuck) {
            System.out.println(list);
        }

        for (int i = freqBuck.length - 1; i >= 0; i--) {
            if (!freqBuck[i].isEmpty()) {
                for (int x = 0; x < freqBuck[i].size(); x++) {
                    result[curIndex] = freqBuck[i].get(x);
                    curIndex++;
                    if (curIndex == result.length) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
