package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * 11001100110011000001
 *
 * 출력 :
 * 4
 *
 * 문제 :
 * https://www.acmicpc.net/problem/1439
 */
import java.io.*;

public class 뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        String newString = changeSameSequenceString(inputString);

        int zeroCount = 0;
        int oneCount = 0;

        for(int i=0; i<newString.length(); i++){
            if(newString.charAt(i) == '0') {
                zeroCount++;
            }else{
                oneCount++;
            }
        }

        if(zeroCount >= oneCount) {
            System.out.println(oneCount);
        }else {
            System.out.println(zeroCount);
        }
    }

    private static String changeSameSequenceString(String inputString){
        StringBuilder sb = new StringBuilder();
        // 첫 문자를 넣음
        sb.append(inputString.charAt(0));

        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) != inputString.charAt(i - 1)) {
                sb.append(inputString.charAt(i));
            }
        }
        return sb.toString();
    }
}
