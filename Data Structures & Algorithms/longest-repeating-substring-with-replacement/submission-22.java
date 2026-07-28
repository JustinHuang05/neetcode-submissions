class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0; 
        int right = 0;
        int result = 0;

        Map<Character, Integer> count = new HashMap<>();
        int maxFreq = 0;
        while (right < s.length()) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(right)));

            while (right - left + 1 - maxFreq > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
