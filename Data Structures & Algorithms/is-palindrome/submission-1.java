class Solution {
    public boolean isPalindrome(String s) {
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.err.print(newString);
        if (newString.length() % 2 == 0) {
            int[] array = new int[newString.length()/2];
            for (int i = 0; i < newString.length()/2; i++) {
                array[i] = newString.charAt(i);
            }
            for (int i = newString.length()/2; i < newString.length(); i++) {
                if (newString.charAt(i) != array[newString.length() - i - 1]) {
                    return false;
                }
            }
        } 
        else {
            int[] array = new int[(newString.length()-1)/2];
            for (int i = 0; i < (newString.length()-1)/2; i++) {
                array[i] = newString.charAt(i);
            }
            for (int i = (newString.length()+1)/2; i < newString.length(); i++) {
                if (newString.charAt(i) != array[newString.length() - i - 1]) {
                    return false;
                }
            }  
        }
        return true;
    }
}
