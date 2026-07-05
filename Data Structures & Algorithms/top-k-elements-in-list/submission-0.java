class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        ArrayList<int[]> tupleList = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tupleList.add(new int[] {entry.getKey(), entry.getValue()});
        }
        tupleList.sort((a, b) -> Integer.compare(b[1], a[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = tupleList.get(i)[0];
        }

        return result;
    }
}