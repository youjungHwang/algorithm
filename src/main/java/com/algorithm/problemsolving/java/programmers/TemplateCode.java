package com.algorithm.problemsolving.java.programmers;

public class TemplateCode {
    // 입출력 확인하는 템플릿 코드
    public int solution(int n, int[][] computers) {
        int answer = 0;
        return answer;
    }
    public static void main(String[] args) {
        TemplateCode check = new TemplateCode();

        // input
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        // 확인하고자 하는 solution 메서드 호출 및 output 출력
        int result = check.solution(n, computers);
        System.out.println("Output: " + result);
    }

}
