import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        // 스택 - 괄호
        while(true) {
            // 띄어쓰기 없는 한 줄로 입력 받음
            String line = scan.nextLine();
            if(line.equals(".")) break;

            out.println(checkStack(line));
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    private static String checkStack(String line) {
        Deque<Character> s = new ArrayDeque<>();

        // String -> char[]
        for(char c : line.toCharArray()) {
            if(c == '(' || c == '[') {
                s.push(c);
            }else if(c == ')') {
                if(s.isEmpty() || s.peek() != '(') {
                    return "no";
                }else {
                    s.pop();
                }
            }else if(c == ']') {
                if(s.isEmpty() || s.peek() != '[') {
                    return "no";
                }else {
                    s.pop();
                }
            }
        }

        if(s.isEmpty()) {
            return "yes";
        }else {
            return "no";
        }
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


