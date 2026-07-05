class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // I'm thinking to go along with sliding window
        // make a copy of the string1 for evey iteration
        // remove the letter from the string copy if the current (right) letter is in s1
        // else, reinit the string copy and move left pointer to cur right + 1

        int left = 0;
        int right = 0;
        String str = s1;
        while (right < s2.length()) {
            if (str.indexOf(s2.charAt(right)) != -1) {
                str = str.substring(0, str.indexOf(s2.charAt(right))) + str.substring(str.indexOf(s2.charAt(right)) + 1, str.length());
                right ++;
            } else {
                str += s2.charAt(left);
                left ++;
            }

            System.out.println(str);

            if (str.isEmpty()) {
                return true;
            }
        }

        return false;

    }
}
