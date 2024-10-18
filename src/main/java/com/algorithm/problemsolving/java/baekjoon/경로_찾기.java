package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 3
 * 0 1 0
 * 0 0 1
 * 1 0 0
 *
 * 출력 : 인접 행렬
 * 1 1 1
 * 1 1 1
 * 1 1 1
 *
 * 문제 : https://www.acmicpc.net/problem/11403
 */
import java.io.*;

public class 경로_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            String[] lineArr = line.split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(lineArr[j]);
            }
        }

        // i에서 j까지 갈 수 있는지 확인
        // = i에서 k로 가고, k에서 j로 갈 수 있는지 확인
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j <n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
