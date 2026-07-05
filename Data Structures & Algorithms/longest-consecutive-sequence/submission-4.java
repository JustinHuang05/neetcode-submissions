class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        ArrayList<Integer> startSet = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                startSet.add(nums[i]);
            }
        }

        int max = 1;
        for (int num : startSet) {
            int count = 1;
            int curNum = num;
            while (true) {
                if (set.contains(curNum + 1)) {
                    count++;
                    curNum++;
                } else {
                    break;
                }
            }

            if (count > max) {
                max = count;
            }
        }
            
        return max;
    }
}
