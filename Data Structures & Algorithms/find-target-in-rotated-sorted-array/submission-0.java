class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        int pivot = left;

        int search1 = binarySearch(nums, target, 0, pivot - 1);

        if (search1 != -1) {
            return search1;
        } else {
            return binarySearch(nums, target, pivot, nums.length - 1);
        }

    }

    private static int binarySearch(int[] nums, int target, int l, int r) {
        int left = l;
        int right = r;

        while(left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}