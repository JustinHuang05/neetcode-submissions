class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();

        int left = 0;
        int right = 0;
        int maxFreqOfWindow = 0;
        int result = 0;

        while (right < s.length()) {
            if (countMap.containsKey(s.charAt(right))) {
                countMap.put(s.charAt(right), countMap.get(s.charAt(right)) + 1);
            } else {
                countMap.put(s.charAt(right), 1);
            }
            maxFreqOfWindow = Math.max(maxFreqOfWindow, countMap.get(s.charAt(right)));


            while (right - left + 1 - maxFreqOfWindow > k) {
                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        } 

        return result;
    }
}
