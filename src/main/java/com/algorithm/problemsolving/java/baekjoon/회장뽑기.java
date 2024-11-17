package com.algorithm.problemsolving.java.baekjoon;
/**
 * 입력 :
 * 5                -> 회원의 수가 있다. 단, 회원의 수는 50명을 넘지 않는다
 * 1 2              -> 친구 관계
 * 2 3
 * 3 4
 * 4 5
 * 2 4
 * 5 3
 * -1 -1            -> 마지막 시그널
 *
 * 출력 :
 * 2 3              -> 회장 후보의 점수와 후보의 수
 * 2 3 4            -> 회장 후보를 오름차순
 *
 * 문제 :
 * - 플로이드워샬 알고리즘 : 모든 쌍에 대해 최단거리 구하기
 */

import java.util.*;
import java.io.*;

public class 회장뽑기 {
    // 그래프 (양방향)
    static List<List<Integer>> graph;
    // 두 정점 관계의 점수
    static int[][] score;
    static int maxValue = Integer.MAX_VALUE;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        while(true) {
            String[] relation = br.readLine().split(" ");
            int x = Integer.parseInt(relation[0]);
            int y = Integer.parseInt(relation[1]);

            if(x == -1 && y == -1) break;

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 두 정점 관계의 점수 초기화
        score = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j) {
                    score[i][j] = 0;
                }else {
                    // 초기값 설정
                    score[i][j] = maxValue;
                }
            }
        }

        // 직접적인 친구는 점수 1로 변경
        for(int i=1; i<=n; i++) {
            for(int neighbor : graph.get(i)) {
                score[i][neighbor] = 1;
            }
        }

        // 플로이드워샬 알고리즘
        // k : 확실하게 거쳐갈 정점을 1번부터 N번까지 순서대로 정의
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    // 친구여야 한다
                    if(score[i][k] != maxValue && score[k][j] != maxValue) {
                        score[i][j] = Math.min(score[i][j], score[i][k] + score[k][j]);
                    }
                }
            }
        }

        // 각 사람마다 점수 계산, 가장 큰 점수를 계산
        int[] totalScore = new int[n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                // 친구여야 한다
                if(score[i][j] != maxValue) {
                    // 한 사람의 인간관계에서 가장 큰 점수를 뽑는다
                    totalScore[i] = Math.max(totalScore[i], score[i][j]);
                }
            }
        }

        // 회장 후보를 담을 ArrayList
        List<Integer> list = new ArrayList<>();

        // totalScore 에서 가장 적은 점수, 해당 점수를 가진 사람들
        int totalMinScore = maxValue;
        for (int i = 1; i <= n; i++) {
            totalMinScore = Math.min(totalMinScore, totalScore[i]);
        }

        // 회장님 후보 수
        int count = 0;
        for(int i=1; i<=n; i++) {
            if(totalScore[i] == totalMinScore) {
                list.add(i);
                count ++;
            }
        }
        System.out.println(totalMinScore + " " + count);

        // 회장 후보 오름차순 정렬 출력
        Collections.sort(list);
        for(int person : list) {
            System.out.print(person + " ");
        }
    }
}
