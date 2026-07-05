class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> charSet = new HashSet<Character>();
        int start = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            while (charSet.contains(s.charAt(i))) {
                charSet.remove(s.charAt(start));
                start ++; 
            }

            charSet.add(s.charAt(i));
            max = Math.max(max, charSet.size());
        }

        return max;
    }
}
