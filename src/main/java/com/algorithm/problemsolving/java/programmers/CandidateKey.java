package com.algorithm.problemsolving.java.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Candidate Key - 조합
 *
 * input(릴레이션) :   학번,   이름,   전공,   학년
 *                [["100","ryan","music","2"],
 *                 ["200","apeach","math","2"],
 *                 ["300","tube","computer","3"],
 *                 ["400","con","computer","4"],
 *                 ["500","muzi","music","3"],
 *                 ["600","apeach","music","2"]]
 * output(최대 후보키 개수) : 2
 *
 * 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42890
 * 풀이: https://lealea.tistory.com/353
 */
public class CandidateKey {
    public int solution(String[][] relation) {
        // 최종 후보 키를 저장할 리스트: 조합 + 최소성 + 유일성 만족
        List<Set<Integer>> candidateKeys = new ArrayList<>();

        // 릴레이션의 행 수
        int rowLen = relation.length;
        // 릴레이션의 열 수
        int colLen = relation[0].length;

        for (int length = 1; length <= colLen; length++) {
            List<Set<Integer>> combinations = new ArrayList<>();

            // 1. 모든 속성 조합을 생성하는 메서드 호출
            getCombinations(0, 0, length, combinations, new HashSet<>(), colLen);

            // 2. 생성된 모든 조합에 대해 최소성과 유일성 검사 시작
            // 2-1. 최소성 검사
            isMinimality(combinations, candidateKeys, relation, rowLen);
        }
        // 후보 키의 개수를 반환
        return candidateKeys.size();
    }

    // 모든 속성 조합을 생성하는 메서드
    public void getCombinations(int start, int depth, int maxDepth,
                                List<Set<Integer>> combinations, Set<Integer> curr,
                                int colLen) {

        // 현재 조합의 길이가 최대 길이(maxDepth)에 도달하면, 해당 조합을 리스트에 추가하고 종료
        if (depth == maxDepth) {
            combinations.add(new HashSet<>(curr));
            return;
        }

        for (int i = start; i < colLen; i++) {
            curr.add(i);
            getCombinations(i + 1, depth + 1, maxDepth, combinations, curr, colLen);
            curr.remove(i);
        }
    }

    // 최소성 검사 메서드
    public void isMinimality(List<Set<Integer>> combinations, List<Set<Integer>> candidateKeys,
                             String[][] relation, int rowLen) {
        for (Set<Integer> cols : combinations) {
            boolean minimality = true;

            // 기존 후보 키들과 비교하여 현재 조합이 최소성을 만족하는지 검사
            for (Set<Integer> key : candidateKeys) {
                // 만약 현재 조합이 기존 후보 키의 부분집합이라면, 최소성 위배
                if (cols.containsAll(key)) {
                    minimality = false;
                    break; // 최소성을 만족하지 않으므로 더 이상 검사할 필요 없음
                }
            }

            // 최소성을 만족할 경우에만 유일성 검사로 넘어감
            if (minimality) {
                // 2-2. 유일성 검사
                isUniqueness(relation, cols, rowLen, candidateKeys);
            }
        }
    }

    // 유일성 검사 메서드
    public void isUniqueness(String[][] relation, Set<Integer> cols,
                             int rowLen, List<Set<Integer>> candidateKeys) {
        Set<String> rowSet = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder rowStr = new StringBuilder();
            for (int col : cols) {
                rowStr.append(row[col]);
            }
            // 각 행의 속성 조합 값으로 구성된 문자열 추가
            rowSet.add(rowStr.toString());
        }

        // rowSet의 크기가 행의 수와 같다면, 모든 행이 유일함을 의미
        if (rowSet.size() == rowLen) {
            candidateKeys.add(new HashSet<>(cols));
        }
    }
}
