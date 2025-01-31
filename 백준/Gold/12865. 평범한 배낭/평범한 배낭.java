 import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int k;
    static int w;
    static int v;
    static int[] dp;

    public static void main(String[] args) {
        // dp[k] = 무게를 k까지 담았을 때 최대 가치(v)
        String[] info = scan.nextLine().split(" ");
        n = Integer.parseInt(info[0]);
        k = Integer.parseInt(info[1]);

        dp = new int[k+1];

        for(int i=0; i<n; i++) {
            String[] bag = scan.nextLine().split(" ");
            w = Integer.parseInt(bag[0]);
            v = Integer.parseInt(bag[1]);

            // 이미 구한 무게(j)가 있고, 무게(j-w)와 비교
            for(int j=k; j>=w; j--) {
                if(dp[j] < dp[j-w] + v) {
                    dp[j] = dp[j-w] + v;
                }
            }
        }
        out.print(dp[k]);

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
