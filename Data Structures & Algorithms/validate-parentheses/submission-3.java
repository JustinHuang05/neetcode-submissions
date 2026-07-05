class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> brackets = new ArrayList<Character>(List.of('[', '(', '{', ']', ')', '}'));
        String justBrackets = "";
        for (int i = 0; i < s.length(); i++) {
            if (brackets.indexOf(s.charAt(i)) != -1) {
                justBrackets += s.charAt(i);
            }
        }
        if (justBrackets.length() % 2 != 0) {
            return false;
        } 
        System.out.println(justBrackets);
        
        ArrayList<Character> bracketBacklog = new ArrayList<Character>();

        for (int i = 0; i < justBrackets.length(); i++) {
            if (brackets.indexOf(justBrackets.charAt(i)) < 3) {
                bracketBacklog.add(0, brackets.get(brackets.indexOf(justBrackets.charAt(i)) + 3));
            } else {
                try {
                    if (justBrackets.charAt(i) != bracketBacklog.get(0)) {
                        return false;
                    } else {
                        bracketBacklog.remove(0);
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }

        if (bracketBacklog.size() != 0) {
            return false;
        }

        return true;
    }
}
