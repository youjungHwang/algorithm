import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int k;
    static int[] dp;
    static int[] number;

    public static void main(String[] args) {
        String[] info = scan.nextLine().split(" ");
        n = Integer.parseInt(info[0]);
        k = Integer.parseInt(info[1]);

        dp = new int[k+1];
        number = new int[n];

        for(int i=0; i<n; i++) {
            int num = scan.nextInt();
            number[i] = num; // 1 2 5
        }

        // dp[K] = k원을 만드는 경우의 수
        // - 이미 알고있는 경우의 수 dp[j] 활용
        dp[0] = 1;
        for(int i=0; i<n; i++) { 
            for(int j=0; j+number[i]<=k; j++) { 
                // dp[j + number[i]]구할 때 이미 구한 dp[j] 누적
                dp[j + number[i]] += dp[j]; 
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
