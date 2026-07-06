class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int secondVal = stack.pop();
                int firstVal = stack.pop();
                stack.push(firstVal + secondVal);
            } else if (tokens[i].equals("-")) {
                int secondVal = stack.pop();
                int firstVal = stack.pop();
                stack.push(firstVal - secondVal);
            } else if (tokens[i].equals("*")) {
                int secondVal = stack.pop();
                int firstVal = stack.pop();
                stack.push(firstVal * secondVal);
            } else if (tokens[i].equals("/")) {
                int secondVal = stack.pop();
                int firstVal = stack.pop();
                stack.push(firstVal / secondVal);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.peek();
    }
}
