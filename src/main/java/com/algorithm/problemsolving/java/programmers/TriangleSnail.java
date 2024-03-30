package com.algorithm.problemsolving.java.programmers;

/**
 * 코딩테스트 연습 > 월간 코드 챌린지 시즌1
 * 삼각 달팽이
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/68645
 * 해설: https://lealea.tistory.com/308
 */

public class TriangleSnail {
    public int[] solution(int n) {
        int x = -1;
        int y = 0;
        int num = 1;
        // 등차수열의 합만큼 배열 크기 생성
        int[] answer = new int[n*(n+1)/2];
        // 2차원 배열 생성
        int[][] arr = new int[n][n];

        // 아래 -> 오른쪽 -> 대각선 반복
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                // 세 방향으로 이동
                if(i%3 ==0){
                    // 아래
                    x++;
                }else if(i%3 == 1){
                    // 오른쪽
                    y++;
                }else{
                    // 대각선
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }

        // arr[x][y] -> answer 배열로 이동
        int k = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[k++] = arr[i][j];
            }
        }

        return answer;
    }
}
