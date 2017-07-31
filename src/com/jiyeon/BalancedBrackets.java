package com.jiyeon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by jiyeon on 2017. 8. 1..
 * Problem : https://www.hackerrank.com/challenges/ctci-balanced-brackets
 * Video : https://www.youtube.com/watch?v=IhJGJG-9Dx8
 */
public class BalancedBrackets {
    final static char[][] TOKEN = {{'{','}'}, {'[',']'}, {'(', ')'}};
    public static boolean isOpenTerm(char c) {
        for(char[] arrays : TOKEN){
            if(arrays[0] == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean matches(char openTerm, char closeTerm){
        for(char[] arrays : TOKEN){
            if(arrays[0] == openTerm) {
                return arrays[1] == closeTerm;
            }
        }
        return false;

    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : expression.toCharArray()){
            if(isOpenTerm(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty() || !matches(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isBalanced2(String expression) {

        // Must be even
        if ((expression.length() & 1) == 1) return false;
        else {
            char[] brackets = expression.toCharArray();
            Stack<Character> s = new Stack<Character>();
            for (char bracket : brackets)
                switch (bracket) {
                    case '{': s.push('}'); break;
                    case '(': s.push(')'); break;
                    case '[': s.push(']'); break;
                    default :
                        if (s.empty() || bracket != s.peek())
                            return false;
                        s.pop();
                }
            return s.empty();
        }

    }

    //////////////////////////////////////////////////////////////////////////////////

    static Map<Character, Character> pair = new HashMap<Character, Character>(); // pair definition

    public static char getPair(char open) { // closing bracket 찾기
        return pair.get(open);
    }

    public static boolean isOpen(char c){ // opening bracket 인지 찾기
        if(pair.containsKey(c)) return true;
        else return false;
    }

    public static boolean isBalanced3(String expression) {
        char[] charArr = expression.toCharArray();
        Stack<Character> openStack = new Stack<Character>();
        Stack<Character> closeStack = new Stack<Character>();

        for(char c : charArr) {
            if(isOpen(c)){
                openStack.add(c);
                closeStack.add(getPair(c)) ;
            }
            else {
                if(closeStack.empty()) return false;
                if (c != closeStack.pop()) return false;
            }
        }

        if(!closeStack.isEmpty()) return false;
        else return true;

    }
    public static void main(String[] args) {
        pair.put('{', '}');
        pair.put('(', ')');
        pair.put('[', ']');

        System.out.println(isBalanced("[]][{]{(({{)[})(}[[))}{}){[{]}{})()[{}]{{]]]){{}){({(}](({[{[{)]{)}}}({[)}}([{{]]({{"));
        System.out.println(isBalanced("[](){()}"));
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("({}([][]))[]()"));
        System.out.println(isBalanced("{)[](}]}]}))}(())("));
    }
}
