package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 5014. 스타트링크 - bfs
 *
 * input : 10 1 10 2 1
 * output: 6
 * 문제: https://www.acmicpc.net/problem/5014
 */
public class StartLink {
    public static void main(String[] args) throws IOException{
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int f = Integer.parseInt(data[0]); // 총 층수
        int s = Integer.parseInt(data[1]); // 지금 있는 층
        int g = Integer.parseInt(data[2]); // 목표 층
        int u = Integer.parseInt(data[3]); // 위로 u만큼 이동
        int d = Integer.parseInt(data[4]); // 아래로 d만큼 이동

        int result = bfs(f,s,g,u,d);
        if(result != -1){
            System.out.println(result);

        }else{
            System.out.println("use the stairs");
        }
    }

    // bfs
    public static int bfs(int f, int s, int g, int u, int d){
        // 큐 생성
        Queue<int[]> queue = new ArrayDeque<>();
        // 큐 넣기 : {현재층, 이동거리}
        queue.add(new int[]{s, 0});
        // 방문 확인
        boolean[] visited = new boolean[1000001];
        visited[s] = true;

        int minCount = 0;

        // 현재 층과 목표 층이 같다면 반환
        if(s == g){
            return 0;
        }

        // 갈 수 있는 방향 2가지
        int[] dy = new int[]{u, -d};

        while(!queue.isEmpty()){
            // 큐에서 하나 poll
            int[] current = queue.poll();
            int curr = current[0]; // 이동한 층
            int distance = current[1]; // 최소거리


            for(int i=0; i<2; i++){
                int moveFloor = curr + dy[i];

                // 이동한 층과 목표 층이 같다면 반환
                if(moveFloor == g){
                    return distance + 1;
                }

                // 경계 안에서 확인
                if (1 <= moveFloor && moveFloor <= f && f <= 1000000 && !visited[moveFloor]) {
                    queue.add(new int[]{moveFloor, distance + 1});
                    visited[moveFloor] = true;
                }
            }
        }
        return -1;
    }
}
