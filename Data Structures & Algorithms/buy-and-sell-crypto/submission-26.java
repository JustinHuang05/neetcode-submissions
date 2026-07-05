class Solution {
    public int maxProfit(int[] prices) {
        int left = 0; 
        int right = 1;
        int maxProfit = 0;

        while (right < prices.length) {
            maxProfit = Math.max(prices[right] - prices[left], maxProfit);

            if (prices[right] < prices[left]) {
                left = right;
                right = left + 1;
            } else {
                right++;
            }
        }

        return maxProfit;
    }
}
// [1, 4, 6, 0, 7]
//for each right, just check if its a better left than the curent left moving forward
