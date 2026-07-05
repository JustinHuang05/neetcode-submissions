class Solution {
    public int maxProfit(int[] prices) {
        int currentMax = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int x = i + 1; x < prices.length; x++) {
                System.out.println(prices[x] + " " + prices[i]);
                if (prices[x] - prices[i] > currentMax) {
                    currentMax = prices[x] - prices[i];
                    System.out.println(currentMax);
                }
            }
        }
        if (currentMax < 0) {
            return 0;
        }
        return currentMax;
    }
}
