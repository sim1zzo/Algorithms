package com.sim1zzo.algorithm_part1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private String input;
    private final List<Character> leftBrackets = Arrays.asList('{','[','(','<');
    private final List<Character> rightBrackets = Arrays.asList('}', ']', ')', '>');

    public Expression(String string) {
        this.input = string;
    }

    public boolean isBalanced(){
        Stack<Character> stack = new Stack<>();
        for( char ch: input.toCharArray()){
            if (isLeftBracket(ch))
                stack.push(ch);
            if (isRightBracket(ch))
                if (stack.empty()) return false;

                var top = stack.pop();
                if (!bracketsMatch(top,ch)) return false;
        }
        return stack.empty();
    }

    private boolean isLeftBracket(char ch){

        return leftBrackets.contains(ch);
    }
    private boolean isRightBracket(char ch){
        return rightBrackets.contains(ch);

    }
    private boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }



    //
//    private final List<Character> left = Arrays.asList('{','[','(','<');
//    private final List<Character> right =  Arrays.asList('}',']',')','>');
//
//    public boolean isBalanced(String input){
//        var stack = new Stack<Character>();
//        if (input == null)
//            throw new IllegalArgumentException();
//
//        for (char ch : input.toCharArray()){
//            if (isLeftBracket(ch) )
//                stack.push(ch);
//
//            if (isRightBracket(ch)) {
//                if (stack.empty()) return false;
//
//                var top = stack.pop();
//                if (!bracketsMatch(top,ch)) return false;
//            }
//        }
//        return stack.empty();
//    }
//    private boolean isLeftBracket(char ch){
//        return left.contains(ch);
//    }
//    private boolean isRightBracket(char ch){
//        return right.contains(ch);
//    }
//    private boolean bracketsMatch(char left, char right){
//        return this.left.indexOf(left) == this.right.indexOf(right);
//    }
}
