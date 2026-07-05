class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = nums[i];
            } else {
                left[i] = nums[i] * left[i - 1];
            }
        }
        
        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                right[i] = nums[i];
            } else {
                right[i] = nums[i] * right[i + 1];
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = right[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = left[i - 1];
            } else {
                result[i] = left[i - 1] * right[i + 1];
            }
        }

        return result;
    }
}  
//ex:
//left: [1, 2, 8, 24]
//right: [48, 48, 24, 6]