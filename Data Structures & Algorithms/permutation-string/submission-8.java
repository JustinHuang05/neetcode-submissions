class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int left = 0;
        int right = s1.length() - 1;

        int[] s1Arr = new int[26];
        int[] windowArr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a'] += 1;
            windowArr[s2.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(s1Arr, windowArr)) {
            return true;
        } else {
            right++;
            left++;
        }

        while (right < s2.length()) {
            windowArr[s2.charAt(right) - 'a'] += 1;
            windowArr[s2.charAt(left - 1) - 'a'] -= 1;

            if (Arrays.equals(s1Arr, windowArr)) {
                return true;
            }

            right++;
            left++;
        }

        return false;
    }
}
