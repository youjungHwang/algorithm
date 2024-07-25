package com.algorithm.problemsolving.java.leetcode;

/**
 * 79. WordSearch
 *
 * Example:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * 문제: https://leetcode.com/problems/word-search/description/
 * 풀이: https://lealea.tistory.com/348
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // board랑 같은 크기의 빈 visited grid 생성 -> 안에 false로 채우기
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 모든 위치에서 백트래킹 시작
                if (backtracking(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 동서남북 이동 방향 설정
    int[] dr = { 0, 0, 1, -1 };
    int[] dc = { 1, -1, 0, 0 };

    public boolean backtracking(char[][] board, String word, boolean[][] visited, int i, int j,
                                int index) {
        // 인덱스가 word의 길이와 같다면 모든 문자를 찾았다는 뜻이므로 true 반환
        if(index == word.length()) return true;

        // 범위를 벗어났거나 이미 방문했거나(true) 현재 문자가 일치하지 않으면 false 반환
        if(i < 0 || i >= board.length || j < 0  || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        // [재귀]
        // 1.현재 위치 방문 처리 (true)
        visited[i][j] = true;

        // 2.동서남북으로 이동하여 백트래킹 시도
        for(int d = 0; d < 4; d++) {
            int newRow = i + dr[d];
            int newCol = j + dc[d];
            if(backtracking(board, word, visited, newRow, newCol, index+1)) {
                return true;
            }
        }

        // 3.현재 위치 방문 해제 (false)
        visited[i][j] = false;

        return false;
    }
}
