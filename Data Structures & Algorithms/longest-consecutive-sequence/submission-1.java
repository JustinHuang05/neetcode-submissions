class Solution {
    public int longestConsecutive(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        ArrayList<Integer> startersList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            int potentialStarter = (list.get(i) - 1);
            if (!list.contains(potentialStarter)) {
                if (!startersList.contains(potentialStarter)) {
                    startersList.add(list.get(i));
                }
            }
        }

        int maxConsecutive = 0;
        for (int i = 0; i < startersList.size(); i++) {
            int curMax = 1;
            int currentInt = startersList.get(i);
            while (true) {
                if (list.contains(currentInt + 1)) {
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
