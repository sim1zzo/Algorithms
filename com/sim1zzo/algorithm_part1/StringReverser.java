package com.sim1zzo.algorithm_part1;

import java.util.Stack;

public class StringReverser {
    private String string = "";

    public StringReverser(String string) {
        this.string = string;
    }

    public String reverse(){
        if (string == "" || string == null)
            return null;
        Stack<Character> stack = new Stack<>();
        for (char ch: string.toCharArray()){
            stack.push(ch);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.empty()){
            stringBuilder.append(stack.pop());
        }

         string = stringBuilder.toString();
        return string;

    }

    @Override
    public String toString(){
        return string;
    }























    //    private String string = "";
//
//    public StringReverser(String string) {
//        this.string = string;
//    }
//    public String reverse(){
//        Stack<Character> stack = new Stack<>();
//
//        if (string == null)
//            throw new IllegalStateException();
//        if (string.length() ==1)
//            return string;
//
//        for (char ch : string.toCharArray()){
//            stack.push(ch);
//        }
//
//        StringBuffer str = new StringBuffer();
//        while (!stack.empty()){
//            var top = stack.pop();
//            str.append(top);
//        }
//        return str.toString();
//
//    }
}
