package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/4949
 * - 스택
 */
import java.util.*;
import java.io.*;

public class _4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input.equals(".")) break;

            // 문자열을 개행을 통해 이어서 붙임
            sb.append(checkValidate(input)).append('\n');
        }
        System.out.println(sb);
    }

    private static String checkValidate(String sentence) {
        // [주의] 한 문장마다 스택 초기화
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<sentence.length(); i++) {
            // 문자열 -> 문자
            char c = sentence.charAt(i);

            if(c == '(' || c == '[') {
                stack.push(c);
            }else if(c == ')' || c == ']') {
                if(stack.isEmpty() || (c == ')' && stack.peek() != '(') || (c ==']' && stack.peek() != '[')) {
                    return "no";
                }else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            return "yes";
        }else {
            return "no";
        }
    }
}
