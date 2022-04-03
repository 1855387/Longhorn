package Week2;

import java.util.*;

public class Calculator {
    // Key instance variables
    private final String expression;
    private ArrayList<String> tokens;
    private ArrayList<String> reverse_polish;
    private Double result;

    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
        OPERATORS.put("^", 2);
        OPERATORS.put("sqrt", 2);
    }

    private final Map<String, Integer> SEPARATORS = new HashMap<>();
    {
        // Map<"separator", not_used>
        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);
    }


    // Print the expression, terms, and result
    public String toString() {
        return ("Original expression: " + this.expression + "\n" +
                "Tokenized expression: " + this.tokens.toString() + "\n" +
                "Reverse Polish Notation: " +this.reverse_polish.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.result));
    }

    public static boolean isNumeric(String n){
        try {
            double d = Double.parseDouble(n);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // Takes RPN and produces a final result
    private void rpnToResult()
    {
        // Stack used to hold calculation while process RPN
        Stack calc = new Stack();

        // for loop to process RPN
        for(int x = 0; x < this.reverse_polish.size(); x++)
        {
            // If the token is a number
            if (isNumeric(this.reverse_polish.get(x))){
                // Push number to stack
                calc.push(this.reverse_polish.get(x));
            }
            // else
            else{
                // Pop the two top entries
                // Based off of Token operator calculate result
                // Push result back onto the stack
                if(Objects.equals(this.reverse_polish.get(x), "sqrt")) {
                    Double number = Double.parseDouble(calc.pop().toString());
                    calc.push(Math.pow(number, 0.5));
                }
                else {
                    Double numb2 = Double.parseDouble(calc.pop().toString());
                    Double numb1 = Double.parseDouble(calc.pop().toString());
                    switch(this.reverse_polish.get(x)){
                        case "+":
                            calc.push(numb1 + numb2);
                            break;
                        case "-":
                            calc.push(numb1 - numb2);
                            break;
                        case "*":
                            calc.push(numb1 * numb2);
                            break;
                        case "/":
                            calc.push(numb1 / numb2);
                            break;
                        case "%":
                            calc.push(numb1 % numb2);
                            break;
                        case "^" :
                            calc.push(Math.pow(numb1, numb2));
                    }
                }
            }
        }
        // Pop final result and set as final result for expression
        result = (Double) calc.pop();
    }


    public Calculator(String expression) {
        // original input
        this.expression = expression;

        // parse expression into terms
        this.termTokenizer();

        // place terms into reverse polish notation
        this.tokensToReversePolishNotation();

        // calculate reverse polish notation
        this.rpnToResult();
    }

    // Term Tokenizer takes original expression and converts it to ArrayList of tokens
    private void termTokenizer() {
        // contains final list of tokens
        this.tokens = new ArrayList<>();

        int start = 0;  // term split starting index
        StringBuilder multiCharTerm = new StringBuilder();    // term holder
        for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {
                // 1st check for working term and add if it exists
                if (multiCharTerm.length() > 0) {
                    tokens.add(this.expression.substring(start, i));
                }
                // Add operator or parenthesis term to list
                if (c != ' ') {
                    tokens.add(c.toString());
                }
                // Get ready for next term
                start = i + 1;
                multiCharTerm = new StringBuilder();
            } else {
                // multi character terms: numbers, functions, perhaps non-supported elements
                // Add next character to working term
                multiCharTerm.append(c);
            }

        }
        // Add last term
        if (multiCharTerm.length() > 0) {
            tokens.add(this.expression.substring(start));
        }
    }

    // Takes tokens and converts to Reverse Polish Notation (RPN), this is one where the operator follows its operands.
    private void tokensToReversePolishNotation () {
        // contains final list of tokens in RPN
        this.reverse_polish = new ArrayList<>();

        // stack is used to reorder for appropriate grouping and precedence
        Stack tokenStack = new Stack();
        for (String token : tokens) {
            switch (token) {
                // If left bracket push token on to stack
                case "(":
                    tokenStack.push(token);
                    break;
                case ")":
                    while (tokenStack.peek() != null && !tokenStack.peek().equals("("))
                    {
                        reverse_polish.add( (String)tokenStack.pop() );
                    }
                    tokenStack.pop();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "^":
                case "sqrt":
                    // While stack
                    // not empty AND stack top element
                    // and is an operator
                    while (!tokenStack.empty() && isOperator((String) tokenStack.peek()))
                    {
                        if ( isPrecedent(token, (String) tokenStack.peek() )) {
                            reverse_polish.add((String)tokenStack.pop());
                            continue;
                        }
                        break;
                    }
                    // Push the new operator on the stack
                    tokenStack.push(token);
                    break;
                default:    // Default should be a number, there could be test here
                    this.reverse_polish.add(token);
            }
        }
        // Empty remaining tokens
        while (!tokenStack.empty()) {
            reverse_polish.add((String)tokenStack.pop());
        }

    }
    // Helper definition for supported operators

    private boolean isOperator(String token) {
        // find the token in the hash map
        return OPERATORS.containsKey(token);
    }

    // Test if token is an separator
    private boolean isSeperator(String token) {
        // find the token in the hash map
        return SEPARATORS.containsKey(token);
    }

    // Compare precedence of operators.
    private Boolean isPrecedent(String token1, String token2) {
        // token 1 is precedent if it is greater than token 2
        return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0) ;
    }

    public static void main(String[] args){
        Calculator simpleMath = new Calculator("100 + 200  * 3");
        System.out.println("Simple Math\n" + simpleMath);
        System.out.println("\n-------------------------\n");


        Calculator parenthesisMath = new Calculator("(100 + 200)  * 3");
        System.out.println("Parenthesis Math\n" + parenthesisMath);
        System.out.println("\n-------------------------\n");

        Calculator allMath = new Calculator("200 % 300 + 5 + 300 / 200 + 1 * 100");
        System.out.println("All Math\n" + allMath);
        System.out.println("\n-------------------------\n");

        Calculator allMath2 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100");
        System.out.println("All Math2\n" + allMath2);
        System.out.println("\n-------------------------\n");

        Calculator allMath3 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100 + 10 ^ 3");
        System.out.println("All Math3\n" + allMath3);
        System.out.println("\n-------------------------\n");

        Calculator allMath4 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100 + 10 ^ 3 + sqrt 4");
        System.out.println("All Math4\n" + allMath4);
        System.out.println("\n-------------------------\n");

        Scanner inp = new Scanner(System.in);
        System.out.println("Enter Mathematical expression:");
        String in = inp.nextLine();
        Calculator custom = new Calculator(in);
        System.out.println("Custom Mathematical Expression: " + custom);
        System.out.println("\n-------------------------\n");

    }
}