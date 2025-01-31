import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {
        // dp[i] = i번째까지 가장 긴 감소하는 수열의 길이
        // 투 포인터로 배열 이동
        // i < j -> dp[i] = dp[j]+1 (단, 기존 dp[i]보다 작으면 무시)

        n = scan.nextInt();

        arr = new int[n];
        String[] info = scan.nextLine().split(" ");
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(info[i]);
            arr[i] = num;
        }

        dp = new int[n];
        // 가장 작아도 자기 자신은 포함하므로, 1로 초기화
        Arrays.fill(dp, 1);

        int max = moveDpArr();
        out.print(max);

        // 자원 해제
        scan.close();
        out.close();
    }

    private static int moveDpArr() {
        int max = 1;

        for(int i=0; i<n; i++) { // 확인하려는 포인터
            for(int j=0; j<i; j++) { // 비교하는 포인터
                // i < j -> dp[i] = dp[j]+1 (단, 기존 dp[i]보다 작으면 무시)
                if(arr[i] < arr[j]) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }
        return max;
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
