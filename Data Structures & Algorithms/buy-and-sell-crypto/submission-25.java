class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = -1;

        if (prices.length <= 1) {
            return 0;
        }

        while (true) {
            int curProfit = prices[right] - prices[left];
            if (curProfit  > 0) {
                if (curProfit > max) {
                    max = curProfit;
                }
                right ++;
            } else {
                left = right;
                right ++;
            }
            if (right == prices.length) {
                break;
            }
        }

        if (max < 0) {
            return 0;
        }

        return max;
    }
}
