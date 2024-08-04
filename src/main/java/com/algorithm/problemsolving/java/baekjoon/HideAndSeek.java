package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 1697. 숨바꼭질 - bfs
 *
 * input : 5 17
 * output: 4
 *
 * 문제: https://www.acmicpc.net/problem/1697
 */
public class HideAndSeek {
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int k = Integer.parseInt(data[1]);

        System.out.println(bfs(n, k));
    }

    public static int bfs(int n, int k) {
        // 큐 생성
        Queue<int[]> queue = new ArrayDeque<>();
        // 큐에 삽입 : n, 이동거리(distance)
        queue.add(new int[]{n, 0});
        // 방문확인 : n, true
        visited[n] = true;
        // 방향 배열 : 현재 노드(n)에서 n-1, n+1, n*2 이동
        int[] dx = {-1, 1, 2};

        // [주의] 시작점과 도착점이 같을 경우 바로 return
        if(n == k){
            return 0;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curr = current[0];
            int distance = current[1];

            // 이동 할 수 있는 3가지 경우의 수
            int next;
            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    next = curr * dx[i];
                } else {
                    next = curr + dx[i];
                }

                if (next == k) {
                    // [주의] 도착시 +1
                    return distance + 1;
                }

                if (next >= 0 && next <= 100000 && !visited[next]) {
                    queue.add(new int[]{next, distance + 1});
                    visited[next] = true;
                }
            }
        }
        // 예외처리
        return -1;
    }
}