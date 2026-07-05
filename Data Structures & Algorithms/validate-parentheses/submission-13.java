class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parenMap = new HashMap<>();
        parenMap.put(')', '(');
        parenMap.put(']', '[');
        parenMap.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (parenMap.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (parenMap.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != parenMap.get(s.charAt(i))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
