class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            idxMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int match = (nums[i] + nums[j]) * -1;
                if (i != j && idxMap.containsKey(match) && idxMap.get(match) != i && idxMap.get(match) != j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(match);
                    Collections.sort(list);
                    if (!resultSet.contains(list)) {
                        resultSet.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}
