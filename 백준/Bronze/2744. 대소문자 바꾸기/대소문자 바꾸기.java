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

        for(int i=0; i<words.length(); i++) {
            char word = words.charAt(i);

            if('A' <= word && word <= 'Z') {
                // 대문자 -> 소문자
                word = (char) ('a' + (word - 'A'));
                System.out.print(word);
            }else if('a' <= word && word <= 'z') {
                // 소문자 - 대문자
                word = (char) ('A' + (word - 'a'));
                System.out.print(word);
            }
        }
    }
}
