class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int curAmt = 0;
                if (heights[i] <= heights[j]) {
                    curAmt = heights[i] * (j - i);
                } else {
                    curAmt = heights[j] * (j - i);
                }
                if (curAmt > max) {
                    max = curAmt;
                }
            }
        }

        return max;
    }
}
