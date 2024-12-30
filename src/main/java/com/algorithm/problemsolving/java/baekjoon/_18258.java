package com.algorithm.problemsolving.java.baekjoon;

/**
 * 문제 : https://www.acmicpc.net/problem/18258
 * - 큐를 구현
 * - Deque<Integer> q = new LinkedList<>();
 */
import java.util.*;
import java.io.*;

public class _18258 {
    // 큐
    private static Deque<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String[] info = br.readLine().split(" ");
                switch(info[0]) {
                    case "push":
                        int num = Integer.parseInt(info[1]);
                        q.add(num);
                        break;
                    case "pop":
                        if(q.isEmpty()) {
                            bw.write("-1" + "\n");
                        }else {
                            bw.write(q.pop() + "\n");
                        }
                        break;
                    case "size":
                        bw.write(q.size() + "\n");
                        break;
                    case "empty":
                        if(q.isEmpty()) {
                            bw.write("1" + "\n");
                        }else {
                            bw.write("0" + "\n");
                        }
                        break;
                    case "front":
                        if(q.isEmpty()) {
                            bw.write("-1" + "\n");
                        }else {
                            bw.write(q.getFirst() + "\n");
                        }
                        break;
                    case "back":
                        if(q.isEmpty()) {
                            bw.write("-1" + "\n");
                        }else {
                            bw.write(q.getLast() + "\n");
                        }
                        break;
                }
        }
        bw.flush();
        bw.close();
    }
}
