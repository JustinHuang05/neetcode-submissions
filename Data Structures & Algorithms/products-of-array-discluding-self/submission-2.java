class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int product = nums[0];
        int zeroCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                zeroCount += 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1 || (zeroCount == 1 && nums[i] != 0)) {
                result[i] = 0;
            } else if (zeroCount == 1 && nums[i] == 0) {
                result[i] = product;
            } else {
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}  
