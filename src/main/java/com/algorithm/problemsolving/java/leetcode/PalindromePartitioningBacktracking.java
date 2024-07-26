package com.algorithm.problemsolving.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning 회문 - 백트래킹 풀이
 *
 * Example:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * 문제: https://leetcode.com/problems/palindrome-partitioning/description/
 * 풀이: https://lealea.tistory.com/350
 */
public class PalindromePartitioningBacktracking {
    // 주어진 문자열 s에 대해 가능한 모든 회문 조합을 찾는 메서드
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtracking(s, 0, new ArrayList<String>(), result);
        return result;
    }

    public void backtracking(String s, int start, List<String> path, List<List<String>> result) {
        // 만약 start 인덱스가 문자열 s의 길이와 같다면 모든 문자를 다 사용한 것이므로 결과에 추가
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // start 인덱스부터 문자열 s의 끝까지 반복
        for (int i = start; i < s.length(); i++) {
            // 현재 부분 문자열이 회문인지 확인
            if (isPalindrome(start, i, s)) {
                // 회문이면 경로에 추가
                path.add(s.substring(start, i + 1));
                // 다음 부분 문자열을 찾기 위해 백트래킹 호출
                backtracking(s, i + 1, path, result);
                // 백트래킹 이전 단계로 돌아가기 위해 경로에서 마지막 요소 제거
                path.remove(path.size() - 1);
            }
        }
    }

    // 주어진 문자열 s의 start 인덱스부터 end 인덱스까지가 회문인지 확인하는 메서드
    public boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            // 만약 현재 문자가 다르면 회문이 아님
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            // 다음 문자로 이동
            start++;
            end--;
        }
        return true; // 모든 문자가 일치하면 회문임
    }
}
