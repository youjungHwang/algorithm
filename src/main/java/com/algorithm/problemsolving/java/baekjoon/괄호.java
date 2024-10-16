package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 6                      -> 숫자
 * (())())                -> 문자열
 * (((()())()
 * (()())((()))
 * ((()()(()))(((())))()
 * ()()()()(()()())()
 * (()((())()(
 *
 * 출력 : 문자열
 * NO
 * NO
 * YES
 * NO
 * YES
 * NO
 *
 * 문제 :
 * https://www.acmicpc.net/problem/9012
 */

import java.util.*;
import java.io.*;

public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String parentheses = br.readLine();

            if(checkIsVps(parentheses)) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean checkIsVps(String parentheses) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<parentheses.length(); i++){
            char curr = parentheses.charAt(i);

            if(curr == '(') {
                stack.push(curr);
            }else if(curr == ')') {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
