class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a'] += 1;
        }
        
        int[] subArr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            subArr[s2.charAt(i) - 'a'] += 1;
        }

        int left = 0;
        int right = s1.length() - 1;

        while (right < s2.length()) {

            int matches = 0;
            for (int i = 0; i < 26; i++) {
                if (s1Arr[i] == subArr[i]) {
                    matches++;
                }
            }
            if (matches == 26) {
                return true;
            }


            subArr[s2.charAt(left) - 'a'] -= 1;
            left++;
            right++;
            if (right < s2.length()) {
                subArr[s2.charAt(right) - 'a'] += 1;
            }
            
        }

        return false;
    }
}
