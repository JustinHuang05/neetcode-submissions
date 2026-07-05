class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        ArrayList<Integer> startersList = new ArrayList<Integer>();
        for (int num : set) {
            if (!set.contains(num - 1) && !startersList.contains(num - 1)) {
                startersList.add(num);
            }
        }

        int maxConsecutive = 0;
        for (int i = 0; i < startersList.size(); i++) {
            int curMax = 1;
            int currentInt = startersList.get(i);
            while (true) {
                if (set.contains(currentInt + 1)) {
                    curMax++;
                    currentInt += 1;
                } else {
                    break;
                }
            }
            if (curMax > maxConsecutive) {
                maxConsecutive = curMax;
            }
        }

        return maxConsecutive;

    }
}
