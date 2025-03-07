import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int[] arr;
    static int[] dp;
    static int n;

    public static void main(String[] args) {
        // dp[i] = i 번째까지 가장 긴 증가하는 부분 수열
        n = scan.nextInt();
        arr = new int[n];

        dp = new int[n];

        String[] info = scan.nextLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }

        // dp 초기값 1로 세팅
        Arrays.fill(dp, 1);

        // 투포인터로 dp 배열 갱신
        int result = findMaxLength();
        out.print(result);

        // 자원 해제
        scan.close();
        out.close();
    }

    private static int findMaxLength() {
        int max = 1;

        // i : 이동하는 포인터
        // j : i와 비교하는 포인터
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
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


