class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxFreqOfWindow = 0;
        int result = 0;

        Map<Character, Integer> count = new HashMap<>();
        
        while (right < s.length()) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxFreqOfWindow = Math.max(maxFreqOfWindow, count.get(s.charAt(right)));

            if (right - left + 1 - maxFreqOfWindow > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;
    }
}
