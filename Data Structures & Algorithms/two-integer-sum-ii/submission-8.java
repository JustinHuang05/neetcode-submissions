class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[l] + numbers[r] == target) {
                int[] result = new int[2];
                result[0] = l + 1;
                result[1] = r + 1;
                return result;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[2];
    }
}
