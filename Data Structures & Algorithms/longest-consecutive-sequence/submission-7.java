class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int count = 1;
                int curNum = nums[i];
                while (set.contains(curNum + 1)) {
                    count++;
                    curNum++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
