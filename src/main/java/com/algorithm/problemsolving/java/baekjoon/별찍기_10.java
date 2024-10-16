package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 3
 *
 * 출력 :
 * ***
 * * *
 * ***
 *
 * 문제 :
 * https://www.acmicpc.net/problem/2447
 */
import java.io.*;

public class 별찍기_10 {
    private static char[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        map = new char[num][num];

        stampStar(0,0, num);

        for(int i=0; i<num; i++){
            bw.write(map[i]);
            bw.newLine();
        }
        bw.flush();
    }

    private static void stampStar(int x, int y, int num) {
        // base case
        if(num == 1) {
            map[x][y] = '*';
            return;
        }

        int dividedSize = num / 3;
        for(int i = 0; i < 3; i ++) {
            for(int j = 0; j < 3; j ++) {
                if(i == 1 && j == 1) {
                    // 항상 5번째(1,1)는 공백
                    fillAllEmptySpace(x + i*dividedSize,y + j*dividedSize, dividedSize);
                }else {
                    stampStar(x + i*dividedSize,y + j*dividedSize, dividedSize);
                }
            }
        }
    }

    private static void fillAllEmptySpace(int x, int y, int num) {
        for(int i = x; i < x+num; i ++) {
            for (int j = y; j < y+num; j ++) {
                map[i][j] = ' ';
            }
        }
    }
}
