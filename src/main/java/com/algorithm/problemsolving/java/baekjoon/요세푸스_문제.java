package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 7 3              -> N명의 사람, 순서대로 K번째 사람을 제거 (1 ≤ K ≤ N ≤ 5,000)
 *
 * 출력 :            -> N명의 사람이 모두 제거될 때까지 계속된다. 그때 순열을 출력
 * <3, 6, 2, 7, 5, 1, 4>
 *
 * 문제 : https://www.acmicpc.net/problem/1158
 * - 큐
 */
import java.util.*;
import java.io.*;

public class 요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // 큐
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {;
            q.add(i);
        }

        // 결과를 담을 배열
        List<Integer> list = new ArrayList<>();

        // 앞의 두 원소를 뒤에 넣고, 세번째 원소를 제거
        while(!q.isEmpty()) {
            for(int i=0; i<k-1; i++) {
                if(!q.isEmpty()) {
                    q.add(q.remove());
                }
            }

            if(!q.isEmpty()) {
                list.add(q.remove());
            }
        }

        System.out.print("<");
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i));
            if(i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
