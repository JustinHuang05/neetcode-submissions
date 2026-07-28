class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                }
                if (right == i) {
                    right--;
                }
                int sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(new ArrayList<>(List.of(nums[left], nums[right], nums[i])));
                    int curLeftNum = nums[left];
                    while (left < right && nums[left] == curLeftNum) {
                        left++;
                    }
                    int curRightNum = nums[right];
                    while (right > left && nums[right] == curRightNum) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
