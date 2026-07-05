class Solution {
    public int maxProfit(int[] prices) {
        int buyIndex = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            System.out.print(" " + prices[buyIndex] + " ");
            int consecutiveProfit = prices[i] - prices[i - 1];
            int gapProfit = prices[i] - prices[buyIndex];
            System.out.print(consecutiveProfit + ", " + gapProfit);

            if (consecutiveProfit >= gapProfit && consecutiveProfit >= maxProfit) {
                buyIndex = i - 1;
                maxProfit = prices[i] - prices[i - 1];
                System.out.print(": happend ");
            } else {
                if (gapProfit >= maxProfit) {
                    maxProfit = prices[i] - prices[buyIndex];
                    System.out.print("k ");
                }
            }
        }

        return maxProfit;
    }
}
