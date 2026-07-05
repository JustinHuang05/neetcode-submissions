class Solution {
    public int[] productExceptSelf(int[] nums) {
        HashMap<Integer, Integer> productMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) { 
                if (j != i) {
                    productMap.put(i, productMap.getOrDefault(i, 1) * nums[j]);
                }   
            }         
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = productMap.getOrDefault(i, 1);
        }
        return res;
    }
}  
