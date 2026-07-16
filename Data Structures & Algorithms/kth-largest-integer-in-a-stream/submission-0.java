class KthLargest {

    private int k;
    private List<Integer> nums = new ArrayList<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            this.nums.add(nums[i]);
        }
    }
    
    public int add(int val) {
        nums.add(val);
        Collections.sort(nums);
        return nums.get(nums.size() - k);
    }
}
