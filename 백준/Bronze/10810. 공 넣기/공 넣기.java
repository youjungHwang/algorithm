import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) {
        String[] info = scan.nextLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);

        arr = new int[n];

        for(int i=0; i<m; i++) {
            String[] balls = scan.nextLine().split(" ");
            int start = Integer.parseInt(balls[0])- 1;
            int end = Integer.parseInt(balls[1])- 1;
            int number = Integer.parseInt(balls[2]);

            // 범위
            for(int j=start; j<=end; j++) {
                arr[j] = number;
            }
        }

         // 출력
        for(int i=0; i<arr.length; i++) {
            out.print(arr[i] + " ");
        }

        // 자원 해제
        scan.close();
        out.close();
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
