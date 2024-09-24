package com.algorithm.problemsolving.java.programmers;

import java.util.*;
/**
 * [고득점 kit] 코딩테스트 연습 > 깊이/너비 우선 탐색(DFS/BFS) > 여행경로 - DFS
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/43164
 */
public class 여행경로 {
    // 방문 확인
    private static boolean[] visited;
    // 결과 배열
    private static List<String> resultArray;

    public String[] solution(String[][] tickets) {
        int ticketsSize = tickets.length;

        // 방문 확인 초기화
        visited = new boolean[ticketsSize];

        // [주의] 결과 배열 초기화
        resultArray = new ArrayList<>();

        // 경로를 저장할 path 배열
        List<String> path = new ArrayList<>();
        path.add("ICN");

        // dfs
        dfs("ICN", path, tickets, 0);

        // 정렬
        Collections.sort(resultArray);

        // 반환
        return resultArray.get(0).split(" ");
    }

    // dfs
    private static void dfs(String now, List<String> path, String[][] tickets, int depth) {
        // 티켓을 다 돌았으면 path를 resultArray에 저장하여 반환
        if(depth == tickets.length) {
            resultArray.add(String.join(" ", path));
            return;
        }

        // 해당 티켓을 사용하지 않았고, 현재 위치와 출발 공항이 일치하는 경우
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && now.equals(tickets[i][0])) {
                // 티켓 사용
                visited[i] = true;
                // 다음 목적지를 경로에 추가
                path.add(tickets[i][1]);
                // 다음 목적지로 DFS 호출
                dfs(tickets[i][1], path, tickets, depth+1);
                // 경로에서 마지막 목적지 제거 (백트래킹)
                path.remove(path.size() - 1);
                // 티켓 사용 해제
                visited[i] = false;
            }
        }
    }
}


