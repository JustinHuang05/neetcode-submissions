class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        int correctMatrixIdx = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (matrix[middle][matrix[middle].length - 1] < target) {
                left = middle + 1;
            } else if (matrix[middle][0] > target) {
                right = middle - 1;
            } else {
                correctMatrixIdx = middle;
                break;
            }
        }

        int[] correctMatrix = matrix[correctMatrixIdx];

        int l = 0;
        int r = correctMatrix.length - 1;

        while (l <= r) {
            int middle = (l + r) / 2;
            if (correctMatrix[middle] < target) {
                l = middle + 1;
            } else if (correctMatrix[middle] > target) {
                r = middle - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
