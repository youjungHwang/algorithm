import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String nextString() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextString());
        }

        long nextLong() {
            return Long.parseLong(nextString());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }
    }

    private static String words;

    static void input() throws IOException {
        FastReader scan = new FastReader();
        words = scan.nextLine();
    }

    public static void main(String[] args) throws IOException {
        input();
        int[] countArr = new int[26];

        for(int i=0; i<words.length(); i++) {
            char word = words.charAt(i);

            // 대문자
            if('A' <= word && word <= 'Z') {
                countArr[word - 'A'] ++;
            }else {
                // 소문자
                countArr[word - 'a'] ++;
            }
        }

        // 배열에서 가장 큰 값 찾기
        int maxCount = -1;
        char maxAlphabet = '?';

        for(int i=0; i<26; i++) {
            if(countArr[i] > maxCount) {
                maxCount = countArr[i];
                maxAlphabet = (char) ('A' + i);
            }

            // 가장 많이 사용된 알파벳이 여러개 일때는 ?를 출력
            else {
                if(countArr[i] == maxCount) {
                    maxAlphabet = '?';
                }
            }
        }
        System.out.print(maxAlphabet);
    }
}
