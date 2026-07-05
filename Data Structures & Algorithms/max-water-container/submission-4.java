class Solution {
    public int maxArea(int[] heights) {

        int maxVol = 0;

        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            int curMax = (right - left) * Math.min(heights[left], heights[right]);
            maxVol = Math.max(maxVol, curMax);
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxVol;
    }
}
