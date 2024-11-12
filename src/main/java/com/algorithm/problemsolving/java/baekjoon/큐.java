package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/10845
 * - 큐를 구현 (링크드리스트로 큐를 구현하기로 함)
 */
import java.util.*;
import java.io.*;

public class 큐 {
    private static List<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            switch(command) {
                case "push" :
                    int num = Integer.parseInt(input[1]);
                    push(num);
                    break;
                case "pop" :
                    pop();
                    break;
                case "size" :
                    size();
                    break;
                case "empty" :
                    empty();
                    break;
                case "front" :
                    front();
                    break;
                case "back" :
                    back();
                    break;
            }
        }
    }

    private static void push(int x) {
        q.add(x);
    }

    private static void pop() {
        // 맨 앞의 원소를 출력 + 해당 원소 삭제
        if(q.isEmpty()) {
            System.out.println(-1);
        }else {
            System.out.println(q.remove(0));
        }
    }

    private static void size() {
        int qSize = q.size();
        System.out.println(qSize);
    }

    private static void empty() {
        if(q.isEmpty()) {
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    private static void front() {
        // 맨 앞의 원소를 출력(해당 원소 삭제x)
        if(q.isEmpty()) {
            System.out.println(-1);
        }else {
            System.out.println(q.get(0));
        }
    }

    private static void back() {
        // 맨 뒤의 원소를 출력(해당 원소 삭제x)
        if(q.isEmpty()) {
            System.out.println(-1);
        }else {
            System.out.println(q.get(q.size() - 1));
        }
    }
}
