class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        List<Integer> starterList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                starterList.add(nums[i]);
            }
        }

        int maxCount = 0;
        for (int num : starterList) {
            int curNum = num;
            int count = 0;
            while (set.contains(curNum + 1)) {           
                count++;
                maxCount = Math.max(maxCount, count);
                curNum++;
            }
            count++;
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
