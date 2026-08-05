class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int pivotIdx = left;

        int leftResult = binarySearch(nums, target, 0, pivotIdx - 1);
        int rightResult = binarySearch(nums, target, pivotIdx, nums.length - 1);

        if (leftResult == -1 && rightResult == -1) {
            return -1;
        } else if (leftResult == -1) {
            return rightResult;
        } else {
            return leftResult;
        }
    }

    private int binarySearch(int[] nums, int target, int startLeft, int startRight) {
        int l = startLeft;
        int r = startRight;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }

        return -1;
    }
}
