import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        // 커서 기준 스택 두개 사용
        int t = scan.nextInt();

        for(int test=0; test<t; test++) {
            String input = scan.nextLine();
            String result = findPassword(input);
            out.println(result);
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    private static String findPassword(String input) {
        // 커서 기준 왼쪽 스택
        Deque<Character> beforeStack = new ArrayDeque<>();
        // 커서 기준 오른쪽 스택
        Deque<Character> afterStack = new ArrayDeque<>();

        for(char c : input.toCharArray()) {
            // 이외 문자
            if(c != '<' && c != '>' && c != '-') {
                beforeStack.addLast(c);
            }

            // 커서
            if(c == '<') {
                if(!beforeStack.isEmpty()) {
                    afterStack.addLast(beforeStack.pollLast());
                }
            }else if(c == '>') {
                if(!afterStack.isEmpty()) {
                    beforeStack.addLast(afterStack.pollLast());
                }
            }

            // 백스페이스
            if(c == '-') {
                if(!beforeStack.isEmpty()) {
                    beforeStack.pollLast();
                }
            }
        }

        //  출력
        StringBuilder sb = new StringBuilder();
        while(!beforeStack.isEmpty()) {
            sb.append(beforeStack.pollFirst());
        }
        while(!afterStack.isEmpty()) {
            sb.append(afterStack.pollLast());
        }

        return sb.toString();
    }

    static class FastReader {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer;

        String nextString() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
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
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void close() {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


