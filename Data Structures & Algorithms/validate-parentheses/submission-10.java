class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = new HashMap<Character, Character>();
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (bracketMap.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (bracketMap.containsValue(s.charAt(i))) {
                    if (!stack.isEmpty()) {
                        if (bracketMap.get(stack.peek()) == s.charAt(i)) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
