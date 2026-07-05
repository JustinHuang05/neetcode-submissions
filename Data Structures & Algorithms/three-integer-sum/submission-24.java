class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (nums[left] + nums[right] < nums[i] * -1) {
                    left++;
                } else if (nums[left] + nums[right] > nums[i] * -1) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[i]);
                    result.add(list);
                    left++;
                    right--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
