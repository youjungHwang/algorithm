package com.algorithm.problemsolving.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens - 백트래킹 풀이
 *
 * 문제: https://leetcode.com/problems/n-queens/description/
 * 풀이: https://lealea.tistory.com/352
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        // 보드 생성 및 초기화
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(String.valueOf('.'));
            }
            board.add(row);
        }

        // 결과 리스트 생성
        List<List<String>> answer = new ArrayList<>();

        // 백트래킹 호출
        backtracking(board, answer, n, 0);
        return answer;
    }

    // 8방향 선언
    public static final int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    public static final int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    // 백트래킹
    public void backtracking(List<List<String>> board, List<List<String>> answer, int n, int row) {
        // 현재 행과 n의 수가 같으면 모든 행에 퀸을 배치한 것이므로, 현재 보드 상태를 결과에 저장
        if (row == n) {
            List<String> solutions = new ArrayList<>();
            for (List<String> rows : board) {
                // 보드의 각 행을 ""로 구분하여 하나의 문자열로 합침
                solutions.add(String.join("", rows));
            }
            answer.add(solutions);
            return;
        }

        // 현재 행(row)에서 각 열(col)을 검사
        for (int col = 0; col < board.size(); col++) {
            if (isValid(board, row, col)) { // 현재 위치에 퀸을 놓을 수 있는지 검사
                board.get(row).set(col, "Q"); // 퀸을 놓음
                backtracking(board, answer, n, row + 1); // 다음 행으로 이동하여 재귀 호출
                board.get(row).set(col, "."); // 퀸을 제거하여 원상태로 되돌림
            }
        }
    }

    // 현재 위치에 퀸을 놓을 수 있는지를 8방향에 대해 확인하는 메서드
    public boolean isValid(List<List<String>> board, int row, int col) {
        for (int i = 0; i < dx.length; i++) {
            int newRow = row;
            int newCol = col;

            // 보드의 유효한 범위 내에서 반복문
            while (newRow + dx[i] >= 0 && newRow + dx[i] < board.size() && newCol + dy[i] >= 0 && newCol + dy[i] < board.size()) {
                newRow += dx[i];
                newCol += dy[i];

                // 현재 위치에 퀸이 있는지 확인, 퀸이 있으면 false 반환
                if (board.get(newRow).get(newCol).equals("Q")) {
                    return false;
                }
            }
        }
        return true;
    }
}
