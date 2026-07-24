class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProducts = new int[nums.length];
        int currentProdLeft = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProducts[i] = currentProdLeft;
            currentProdLeft *= nums[i];
        }

        int[] rightProducts = new int[nums.length];
        int currentProdRight = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightProducts[i] = currentProdRight;
            currentProdRight *= nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }
}  
