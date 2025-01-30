import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    // 곡의 개수
    static int n;
    // 시작 볼륨
    static int s;
    // 최대 가능 볼륨
    static int m;

    // dp[A][B] = A번째 곡에서 볼륨 B로 연주할 수 있는가
    static boolean[][] dp;
    // 볼륨 +,- 가능한 리스트
    static int[] volumeArr;
    
    public static void main(String[] args) {
        String[] info = scan.nextLine().split(" ");
        n = Integer.parseInt(info[0]);
        s = Integer.parseInt(info[1]);
        m = Integer.parseInt(info[2]);

        dp = new boolean[n][m+1];

        volumeArr = new int[n];
        String[] nInfo = scan.nextLine().split(" ");
        for(int i=0; i<n; i++) {
            int vList = Integer.parseInt(nInfo[i]);
            volumeArr[i] = vList;
        }

        findLastMusicVolume();

        // 자원 해제
        scan.close();
        out.close();
    }

    private static void findLastMusicVolume() {
        // 첫 곡은 직접 구함
        if(s + volumeArr[0] <= m){
            dp[0][s + volumeArr[0]] = true;
        }
        if(s - volumeArr[0] >= 0) {
            dp[0][s - volumeArr[0]] = true;
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=m; j++) {
                // 이전 곡이 볼륨 j로 연주가 가능한 경우
                if(dp[i-1][j]) {
                    if(j + volumeArr[i] <= m){
                        dp[i][j + volumeArr[i]] = true;
                    }
                    if(j - volumeArr[i] >= 0) {
                        dp[i][j - volumeArr[i]] = true;
                    }
                }
            }
        }

        // 마지막 곡에서 가능한 볼륨 중 가장 큰 값을 출력
        for(int i=m; i>=0; i--) {
            if(dp[n-1][i]) {
                out.print(i);
                return;
            }
        }
        
        // 없으면 -1출력
        out.print(-1);
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
