package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 8
 * 11110000
 * 11110000
 * 00011100
 * 00011100
 * 11110000
 * 11110000
 * 11110011
 * 11110011
 *
 * 출력 : ((110(0101))(0010)1(0001))
 *
 * 문제 : 한 영역 안에서 원소가 다 같은지 확인 (분할정복 알고리즘)
 * https://www.acmicpc.net/problem/1992
 */

import java.io.*;

public class 쿼드트리 {
    private static int[][] map;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 2차원 배열에 정수 원소를 넣음
        // String -> Character -> int
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        checkQuadTree(0,0, N);
        System.out.print(sb);
    }

    private static void checkQuadTree(int x, int y, int size) {
        if(isAllSameNumber(x,y,size)) {
            // [합침]
            sb.append(map[x][y]);
            return;
        }

        // [분할] 분할된 영역안의 원소가 다르다면, 4분할하여 재귀적으로 확인
        // 시작 (, 끝 )
        sb.append("(");
        // 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래
        checkQuadTree(x, y, size/2);
        checkQuadTree(x, y + size/2,size/2);
        checkQuadTree(x + size/2, y,size/2);
        checkQuadTree(x + size/2, y + size/2,size/2);
        sb.append(")");
    }

    private static boolean isAllSameNumber(int currX, int currY, int size) {
        // [정복] 분할된 영역안의 원소가 전부 같은가?
        int dot = map[currX][currY];

        for(int i=currX; i<currX + size; i++ ) {
            for(int j=currY; j<currY + size; j++){
                if(map[i][j] != dot) {
                    return false;
                }
            }
        }
        return true;
    }
}
