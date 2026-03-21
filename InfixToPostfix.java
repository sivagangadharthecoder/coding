import java.util.Stack;

public class InfixToPostfix {

    private static int precedence(char operator) {
        char c = operator;
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static String convert(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (c == ' ')
                continue;
            else if (!isOperator(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() &&
                        precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
            System.out.println("infix at i " + i + " : " + infix);
            System.out.println("postfix at i " + i + " : " + postfix);
            System.out.println("stack at i " + i + " : " + stack);
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        System.out.println("postfix: " + postfix);
        System.out.println("stack: " + stack);

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "A + B * C - D / E";

        System.out.println("infix: " + infix);
        System.out.println("postfix: " + convert(infix));

    }
}
