class Solution {
    public boolean isPalindrome(String s) {

        String lowerCase = s.toLowerCase();

        int left = 0; 
        int right = s.length() - 1;
        for (int i = 0; i < lowerCase.length(); i++) {
            System.out.println(left);
            System.out.println(right);
            if (!Character.isLetterOrDigit(lowerCase.charAt(left)) && Character.isLetterOrDigit(lowerCase.charAt(right))) {
                left++;
            } else if (!Character.isLetterOrDigit(lowerCase.charAt(right)) && Character.isLetterOrDigit(lowerCase.charAt(left))) {
                right --;
            } else if (!Character.isLetterOrDigit(lowerCase.charAt(right)) && !Character.isLetterOrDigit(lowerCase.charAt(left))) {
                left ++;
                right --;
            } else { 
                if (lowerCase.charAt(left) != lowerCase.charAt(right)) {
                    return false;
                }
                left ++;
                right --;
            }
        }

        return true;
    }
}
