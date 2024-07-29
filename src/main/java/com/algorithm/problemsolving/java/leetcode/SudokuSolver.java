package com.algorithm.problemsolving.java.leetcode;

/**
 * 37. Sudoku Solver - 백트래킹 풀이
 *
 * 문제: https://leetcode.com/problems/sudoku-solver/description/
 * 풀이: https://lealea.tistory.com/351
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtracking(board, 0);
    }

    public boolean backtracking(char[][] board, int s) {
        // base case : 만약 s가 81이면 모든 셀을 확인했으므로 true 반환
        if (s == 81) return true;

        // (i, j): 9*9에서의 셀 위치 계산
        int i = s / 9;
        int j = s % 9;

        // 현재 셀이 빈 셀이 아니면 다음 셀로 이동
        if (board[i][j] != '.') {
            return backtracking(board, s + 1);
        }

        for (char c = '1'; c <= '9'; c++) {
            // 현재 셀에 숫자 c를 넣을 수 있는지 확인
            if (isValid(board, i, j, c)) {
                // 숫자 c를 현재 셀에 넣음
                board[i][j] = c;
                // 다음 셀로 이동하여 백트래킹 호출
                if (backtracking(board, s + 1)) {
                    // 성공적으로 해결된 경우 true 반환하여 현재 함수를 종료하고 이전 호출 스택으로 돌아감
                    return true;
                } else {
                    // 현재 숫자가 정답이 아니라면 해당 셀을 초기화
                    board[i][j] = '.';
                }
            }
        }
        // 모든 숫자를 시도해도 해결되지 않은 경우 false 반환
        return false;
    }

    public boolean isValid(char[][] board, int row, int col, char c) {
        // 현재 숫자가 9*9 기준 행, 열, 그리고 3x3내에 중복되지 않는지 확인
        for (int i = 0; i < 9; i++) {
            // 행을 기준으로 중복 확인
            if (board[i][col] == c) return false;
            // 열을 기준으로 중복 확인
            if (board[row][i] == c) return false;
            // 3x3 기준으로 중복 확인
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
}
