import java.util.Scanner;

/**
 * @author Armin Rezaiyan-Nojani
 * The Notation class provides methods for converting and evaluating infix and postfix notation expressions.
 */

public class Notation {

    /**
     * Converts an infix notation expression to a postfix notation expression.
     * @param infix the infix notation expression to be converted
     * @return the postfix notation expression as a String
     * @throws InvalidNotationFormatException if the notation of the expression is invalid
     */
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
        
    	try {
            MyStack<Character> stack = new MyStack<>();
            StringBuilder postfix = new StringBuilder();
            char[] infixChars = infix.toCharArray();
            for (char c : infixChars) {
                if (Character.isDigit(c)) {
                    postfix.append(c);
                }
                if (c == '(') {
                    stack.push(c);
                }
                if (c == ')') {
                    while (!stack.isEmpty() && stack.top() != '(') {
                        postfix.append(stack.pop());
                    }
                    if (!stack.isEmpty() && stack.top() != '(') {
                        throw new InvalidNotationFormatException();
                    }
                    stack.pop();
                }
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.top())) {
                        postfix.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
            while (!stack.isEmpty()) {
                postfix.append(stack.pop());
            }
            return postfix.toString();
        } catch (Exception e) {
            throw new InvalidNotationFormatException();
        }
    }

    /**
     * Converts a postfix notation expression to an infix notation expression.
     * @param postfix the postfix notation expression to be converted
     * @return the infix notation expression as a String
     * @throws InvalidNotationFormatException if the notation of the expression is invalid
     */
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
        
    	try {
            MyStack<String> stack = new MyStack<>();
            char[] postfixChars = postfix.toCharArray();
            for (char c : postfixChars) {
                if (Character.isDigit(c)) {
                    stack.push(c + "");
                }
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    String x = stack.pop();
                    String y = stack.pop();
                    stack.push("(" + y + c + x + ")");
                }
            }
            if (stack.size() == 1) {
                return stack.pop();
            }
            throw new InvalidNotationFormatException();
        } catch (Exception e) {
            throw new InvalidNotationFormatException();
        }
    }

    /**
     * Evaluates a postfix expression and returns the result.
     *
     * @param postfixExpr the postfix expression to be evaluated
     * @return the result of the postfix expression evaluation
     * @throws InvalidNotationFormatException if the postfix expression is invalid
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {

        MyStack<Double> stack = new MyStack<>();

        try {
            for (char c : postfixExpr.toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                if (isOperand(Character.toString(c)) || c == '(') {
                    try {
                        stack.push(Double.parseDouble(Character.toString(c)));
                    } catch (NumberFormatException e) {
                        throw new InvalidNotationFormatException();
                    }
                }
                else if (isOperator(Character.toString(c))) {
                    if (stack.size() < 2) {
                        throw new InvalidNotationFormatException();
                    }
                    double y = stack.pop();
                    double x = stack.pop();
                    double result = 0;
                    if (c == '+') {
                        result = x + y;
                    } else if (c == '-') {
                        result = x - y;
                    } else if (c == '*') {
                        result = x * y;
                    } else if (c == '/') {
                        result = x / y;
                    }
                    stack.push(result);
                }
                else if (c != ')') {
                    throw new InvalidNotationFormatException();
                }
            }
        } catch (Exception e) {
            throw new InvalidNotationFormatException();
        }

        if (stack.size() == 1) {
            try {
				return stack.pop();
			} catch (StackUnderflowException e) {
				throw new InvalidNotationFormatException();
			}
        } else {
            throw new InvalidNotationFormatException();
        }
    }
    
    /*
     * HELPER FUNCTIONS
     */

    // Check if a given string is an operand (can be parsed as double)
    private static boolean isOperand(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Check if a given string is an operator (+, -, * or /)
    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
    
    // returns operator precedence for convert infix to postfix
    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}

