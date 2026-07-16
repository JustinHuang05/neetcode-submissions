class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

// class KthLargest {

//     private int k;
//     private List<Integer> nums = new ArrayList<>();

//     public KthLargest(int k, int[] nums) {
//         this.k = k;
//         for (int i = 0; i < nums.length; i++) {
//             this.nums.add(nums[i]);
//         }
//     }
    
//     public int add(int val) {
//         nums.add(val);
//         Collections.sort(nums);
//         return nums.get(nums.size() - k);
//     }
// }
