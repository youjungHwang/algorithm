package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 8                            -> 한 변의 길이 N
 * 1 1 0 0 0 0 1 1              -> 하얀색 색종이(0), 파란색 색종이(1)
 * 1 1 0 0 0 0 1 1
 * 0 0 0 0 1 1 0 0
 * 0 0 0 0 1 1 0 0
 * 1 0 0 0 1 1 1 1
 * 0 1 0 0 1 1 1 1
 * 0 0 1 1 1 1 1 1
 * 0 0 1 1 1 1 1 1
 *
 * 출력 :
 * 9                            -> 햐얀색 색종이 개수
 * 7                            -> 파란색 색종이 개수
 *
 * 문제 : https://www.acmicpc.net/problem/2630
 */
import java.io.*;

public class 색종이_만들기 {
    static int[][] board;
    static int writePaperCount = 0;
    static int bluePaperCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // board 배열 초기화
        board = new int[N][N];

        // board 초기화
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            String[] lineArr = line.split(" ");
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(lineArr[j]);
            }
        }

        isAllSameColor(0,0,N);
        System.out.println(writePaperCount);
        System.out.println(bluePaperCount);
    }

    private static void isAllSameColor(int startRow, int startCol, int N) {
        // 1. 종료 조건
        if(N == 1) {
            if(board[startRow][startCol] == 1) {
                bluePaperCount++;
                return;
            }else {
                writePaperCount++;
                return;
            }
        }

        // 2. 종료 조건: 분할된 칸에 있는 모든 원소가 같은 숫자인지 확인
        boolean isSameColor = true;
        int firstColor = board[startRow][startCol];

        for(int i=startRow; i<startRow + N; i++) {
            for(int j=startCol; j<startCol + N; j++) {
               if(firstColor != board[i][j]) {
                   isSameColor = false;
                   break;
               }
            }
            if(!isSameColor) break;
        }

        if(isSameColor) {
            if(firstColor == 1) {
                bluePaperCount++;
            }else {
                writePaperCount++;
            }
        } else {
            // 분할
            int dividedLength = N / 2;
            isAllSameColor(startRow, startCol, dividedLength);
            isAllSameColor(startRow, N / 2 + startCol, dividedLength);
            isAllSameColor(N / 2 + startRow, startCol, dividedLength);
            isAllSameColor(N / 2 + startRow, N / 2 + startCol, dividedLength);
        }
    }
}
