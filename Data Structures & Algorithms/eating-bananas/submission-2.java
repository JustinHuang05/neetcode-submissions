class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxRate = 0;
        for (int bananas : piles) {
            maxRate = Math.max(maxRate, bananas);
        }

        int left = 1;
        int right = maxRate;
        int minEatingSpeed = maxRate;

        while (left <= right) {
            int mid = (left + right) / 2;
            int hours = 0;
            for (int bananas : piles) {
                if (bananas % mid != 0) {
                    hours += bananas / mid + 1;
                } else {
                    hours += bananas / mid;
                }
            }
            if (hours > h) {
                left = mid + 1;
            } else {
                minEatingSpeed = mid;
                right = mid - 1;
            }
        }

        return minEatingSpeed;
    }
}
