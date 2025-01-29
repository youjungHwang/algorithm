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

    private static int n;
    private static int[] dp;

    static void input() throws IOException {
        FastReader scan = new FastReader();

        n = scan.nextInt();
        dp = new int[n+1];
    }

    public static void main(String[] args) throws IOException {
        input();

        if(n == 1) {
            System.out.print(1);
            return;
        }else if(n == 2) {
            System.out.print(2);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
         }
        System.out.print(dp[n]);
    }
}
