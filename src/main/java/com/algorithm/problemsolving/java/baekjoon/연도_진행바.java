package com.algorithm.problemsolving.java.baekjoon;

/**
 * 입력 :
 * July 02, 2007 12:00   -> Month DD, YYYY HH:MM 형태
 *
 * 출력 :
 * 50.0
 *
 * 문제 : https://www.acmicpc.net/problem/1340
 * - 문자열 파싱 문제
 *
 * [풀이]
 * 1. 윤년인지 확인
 * 2. 일, 시간 -> 전부 일로 환산 (하루 1,440분)
 * 3. (일 / 365) * 100
 */
import java.io.*;

public class 연도_진행바 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] monthData = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String[] info = br.readLine().split(" ");
        // 문자열 파싱
        String month = info[0];
        int day = Integer.parseInt(info[1].replace(",","")); // , 제거
        int year = Integer.parseInt(info[2]);
        String[] time = info[3].split(":");
        int hour = Integer.parseInt(time[0]);
        int minute =  Integer.parseInt(time[1]);

        // 윤년일 경우 2월의 일수를 29일로 변경
        if (isYoonYear(year)) {
            dayOfMonth[1] = 29;
        }

        // month에 매칭되는 monthData배열 인덱스
        int untilMonth = 0;
        for(int i=0; i<monthData.length; i++) {
            if(monthData[i].equals(month)) {
                untilMonth = i;
            }
        }

        // 2-1. 해당 month -1 까지 day 수를 합함
        int untilDay = 0;
        for(int i=0; i<untilMonth; i++) {
            untilDay += dayOfMonth[i];
        }

        // 현재 월의 날짜를 더함
        untilDay += day - 1;

        // 2-2. 시간과 분을 day로 환산
        int hourToMin = hour * 60;
        double hourAndMinuteToDay = (double) (hourToMin + minute) / 1440;

        //  3. (일 / 365) * 100
        double totalDay = untilDay + hourAndMinuteToDay;

        double result;
        if(isYoonYear(year)) {
            result = (totalDay / 366) * 100;
        }else {
            result = (totalDay / 365) * 100;
        }

        // 결과 출력
        System.out.println(result);
    }

    // 1. 주어진 연도가 윤년인지 아닌지 확인하는 메서드
    private static boolean isYoonYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true; // 400으로 나누어 떨어지면 윤년
                } else {
                    return false; // 100으로 나누어 떨어지지만 400으로는 나누어 떨어지지 않으면 윤년 아님
                }
            }
            return true; // 4로 나누어 떨어지지만 100으로는 나누어 떨어지지 않으면 윤년
        }
        return false; // 4로 나누어 떨어지지 않으면 윤년 아님
    }
}
