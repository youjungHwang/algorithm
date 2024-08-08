package com.algorithm.problemsolving.java.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 9205. 맥주 마시면서 걸어가기 - bfs
 *
 * input:
 * 2                         // 테스트 케이스 개수
 * 2                         // 맥주를 파는 편의점 개수 n (0 ≤ n ≤ 100)
 * 0 0                       // n+2개 줄에 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표
 * 1000 0
 * 1000 1000
 * 2000 1000
 * 2                         // 맥주를 파는 편의점 개수 n (0 ≤ n ≤ 100)
 * 0 0                       // n+2개 줄에 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표
 * 1000 0
 * 2000 1000
 * 2000 2000
 *
 * output:                   // 중간에 맥주가 바닥나서 더 이동할 수 없으면 "sad" 출력
 * happy
 * sad
 *
 * 문제: https://www.acmicpc.net/problem/9205
 */
public class BeerWalk {
    private static String result;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        // 결과 저장할 리스트
        List<String> results = new ArrayList<>();

        // 테스트 케이스 수 만큼 돌면서
        for(int i=0; i<testCase; i++){
            int numStore = Integer.parseInt(br.readLine());

            // 좌표를 담을 배열
            int[][] map = new int[numStore+2][2];
            for(int j=0; j<numStore+2; j++){ // 0 1 2 3
                String[] codes = br.readLine().split(" ");
                map[j][0] = Integer.parseInt(codes[0]);
                map[j][1] = Integer.parseInt(codes[1]);
            }

            if (isBeerWalk(map)) {
                results.add("happy");
            } else {
                results.add("sad");
            }
        }

        // 출력
        for (String result : results) {
            System.out.println(result);
        }
    }

    // 맥주를 걸으면서 먹을 수 있는지 확인하는 메서드
    // -> map 확인
    /*
    *   [0, 0]
        [1000, 0]
        [1000, 1000]
        [2000, 1000]

        [0, 0]
        [1000, 0]
        [2000, 1000]
        [2000, 2000]
    * */
    public static boolean isBeerWalk(int[][] map){
        int n = map.length;
        // 큐 선언
        Queue<Integer> queue = new ArrayDeque<>();
        // 큐 넣기
        queue.add(0);
        // 방문 확인
        boolean[] visited = new boolean[n];
        visited[0] = true;

        while (!queue.isEmpty()){
            // 큐에서 현재위치 뽑음
            int curr = queue.poll();

            // [주의] 페스티벌 위치에 도달하면 true 반환
            if (curr == n - 1) {
                return true;
            }

            for(int i=0; i<n; i++){ // 0 1 2 3
                // 방문한 적이 없고, 맨하튼 거리 계산 후 1000 이하면
                if(!visited[i]){
                    int distance =
                            Math.abs(map[curr][0] - map[i][0]) + Math.abs(map[curr][1] - map[i][1]);
                    if(distance <= 1000){
                        // 큐에 넣고, 방문 확인
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
        // 페스티벌에 도달할 수 없는 경우 false 반환
        return false;
    }

}
