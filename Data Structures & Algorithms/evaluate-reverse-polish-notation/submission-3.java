class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(first + second));
            } else if (tokens[i].equals("-")) {                
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(first - second));
            } else if (tokens[i].equals("*")) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(first * second));
            } else if (tokens[i].equals("/")) {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(first / second));
            } else {
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.peek());
    }
}
