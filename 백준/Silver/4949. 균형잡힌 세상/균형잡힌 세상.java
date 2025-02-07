import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        while(true) {
            char[] sentence = scan.nextLine().toCharArray();

            if(sentence[0] == '.') break;

            String result = isBalancedWorld(sentence);

            System.out.println(result);
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    private static String isBalancedWorld(char[] sentence) {

        Deque<Character> s = new ArrayDeque<>();

        for(int i=0; i<sentence.length; i++) {
            if(sentence[i] == '(') {
                s.addFirst('(');
            }

            if(sentence[i] == '[') {
                s.addFirst('[');
            }

            if(sentence[i] == ')' || sentence[i] == ']' ) {
                if(s.isEmpty() || (sentence[i] == ')' && s.peek() != '(') ||
                        (sentence[i] == ']' && s.peek() != '[') ) {
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
