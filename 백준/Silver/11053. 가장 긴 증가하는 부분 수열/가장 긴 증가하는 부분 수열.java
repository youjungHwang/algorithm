import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) {
        // dp[i] = i번째 까지의 가장 긴 부분 수열의 길이
        // 투 포인터 사용 -> 배열 갱신
        // j < i -> dp[i] = dp[j] + 1 (단, 기존 값보다 작으면 무시)

        n = scan.nextInt();

        arr = new int[n];
        String[] info = scan.nextLine().split(" ");
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(info[i]);
            arr[i] = num;
        }

        dp = new int[n];
        Arrays.fill(dp, 1);

        // 투 포인터로 dp배열 갱신
       int max = moveDpArr();

        out.print(max);

        // 자원 해제
        scan.close();
        out.close();
    }

    private static int moveDpArr(){
        int max = 1;

        // 투 포인터
        for(int i=0; i<n; i++) { // 이동하는 포인터
            for(int j=0; j<i; j++) { // 비교하는 포인터
                if(arr[j] < arr[i]) {
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
