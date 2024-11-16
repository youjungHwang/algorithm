package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/10828
 */
import java.io.*;

public class 스택 {
    static int[] stack;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stack = new int[n];

        for(int i=0; i<n; i++){
            String[] data = br.readLine().split(" ");
            String command = data[0];

            switch(command) {
                case "push" :
                    Integer num = Integer.parseInt(data[1]);
                    push(num);
                    break;
                case "pop" :
                    pop();
                    break;
                case "size" :
                    printSize();
                    break;
                case "empty" :
                    empty();
                    break;
                case "top" :
                    top();
                    break;
            }
        }
    }

    private static void push(int num) {
        stack[size] = num;
        size++;
    }

    private static void pop() {
        if(size == 0) {
            System.out.println(-1);
        }else{
            int popN = stack[size -1];
            size--;
            System.out.println(popN);
        }
    }

    private static void printSize() {
        System.out.println(size);
    }

    private static void empty() {
        if(size == 0) {
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    private static void top() {
        if(size == 0) {
            System.out.println(-1);
        }else{
            int topN = stack[size -1];
            System.out.println(topN);
        }
    }
}
