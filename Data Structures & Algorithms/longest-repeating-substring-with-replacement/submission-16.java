class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();

        int left = 0;
        int right = 0;
        int result = 0;

        while (right < s.length()) {
            if (countMap.containsKey(s.charAt(right))) {
                countMap.put(s.charAt(right), countMap.get(s.charAt(right)) + 1);
            } else {
                countMap.put(s.charAt(right), 1);
            }
            
            int maxFreqOfWindow = Collections.max(countMap.values());
            //alg is still linear time bc this is at most 26 characters long map

            while (right - left + 1 - maxFreqOfWindow > k) {
                countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                left++;
                maxFreqOfWindow = Collections.max(countMap.values());
            }

            result = Math.max(result, right - left + 1);
            right++;
        } 

        return result;
    }
}
