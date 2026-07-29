class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        int[] correctMatrix = null;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (matrix[middle][0] > target) {
                right = middle - 1;
            } else if (matrix[middle][matrix[middle].length - 1] < target) {
                left = middle + 1;
            } else {
                correctMatrix = matrix[middle];
                break;
            }
        }

        if (correctMatrix == null) {
            return false;
        }

        int l = 0;
        int r = correctMatrix.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (correctMatrix[m] > target) {
                r = m - 1;
            } else if (correctMatrix[m] < target) {
                l = m + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
