class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            if (prices[right] < prices[left]) {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
