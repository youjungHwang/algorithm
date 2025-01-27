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
    private static int m;
    private static char[][] map;

    static void input() throws IOException {
        FastReader scan = new FastReader();

        String[] info = scan.nextLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);

        // map 초기화
        map = new char[n][m];
        for(int i=0; i<n; i++) {
            String lineData = scan.nextLine();
            for(int j=0; j<m; j++) {
                // string -> char
                map[i][j] = lineData.charAt(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        // 각 행과 열에 경비원이 있는지 확인
        boolean[] existRow = new boolean[n];
        boolean[] existCol = new boolean[m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'X') {
                    existRow[i] = true;
                    existCol[j] = true;
                }
            }
        }

        // 경비원이 필요한 행, 열 중 큰 값을 반환
        int needPoliceRow = n;
        int needPoliceCol = m;

        for(int i=0; i<n; i++) {
            if(existRow[i]) {
                needPoliceRow -= 1;
            }
        }

        for(int j=0; j<m; j++) {
            if(existCol[j]) {
                needPoliceCol -= 1;
            }
        }

        int count = Math.max(needPoliceRow, needPoliceCol);
        System.out.print(count);
    }
}
