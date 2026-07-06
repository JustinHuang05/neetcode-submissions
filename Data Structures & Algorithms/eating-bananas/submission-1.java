class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int left = 1;
        int right = max;

        int result = max;
        while (left <= right) {
            int middle = (left + right) / 2;
            int hours = 0;
            for (int i = 0; i < piles.length; i++) {
                int remainder = piles[i] % middle;
                if (remainder > 0) {
                    hours += piles[i] / middle + 1;
                } else {
                    hours += piles[i] / middle;
                }
            }

            if (hours <= h) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            
        }

        return result;
    }
}
