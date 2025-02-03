import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static char[][] map;
    static int result;

    public static void main(String[] args) {
        /**
         * 완전 탐색 : O(n^4)
         * - n은 최대 50이라 충분
         * - 격자에서 증가하는 부분만 확인하여 중복으로 확인 x(열 또는 행이 1증가하는 부분)
         *
         * [방법]
         * 1. 이중 for문 : O(n^2)
         *   - 증가하는 행 확인(스왑해서 확인 후 다시 스왑해서 제자리)
         *   - 증가하는 열 확인(스왑해서 확인 후 다시 스왑해서 제자리)
         * 2. 이중 for문 : O(n^2)
         * 3. 1 * 2
         */

        n = scan.nextInt();
        map = new char[n][n];

        for(int i=0; i<n; i++) {
            char[] info = scan.nextLine().toCharArray();
            for(int j=0; j<n; j++) {
                map[i][j] = info[j];
            }
        }

        result = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 최대 증가하는 행 확인
                if(j+1 < n && map[i][j] != map[i][j+1]) {
                    swapBomboni(i,j,i,j+1);
                    result = Math.max(result, Math.max(findMaxRow(), findMaxCol()));
                    // 원상복구
                    swapBomboni(i,j,i,j+1);
                }

                // 최대 증가하는 열 확인
                if(i+1 < n && map[i][j] != map[i+1][j]) {
                    swapBomboni(i,j,i+1,j);
                    result = Math.max(result, Math.max(findMaxRow(), findMaxCol()));
                    // 원상복구
                    swapBomboni(i,j,i+1,j);
                }
            }
        }

        out.print(result);

        // 자원 해제
        scan.close();
        out.close();
    }

    private static void swapBomboni(int x1, int y1, int x2, int y2) {
        char temp;

        temp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = temp;
    }

    // 행
    private static int findMaxRow() {
        int maxRow = 0;

        for(int row=0; row<n; row++) { 
            // 이미 하나는 있다고 판단해 j는 1부터 시작
            int count = 1;
            for(int col=1; col<n; col++) { 
                // 연속 문자 확인
                if(map[row][col] == map[row][col-1]) {
                    count ++;
                }else {
                    // 갱신
                    maxRow = Math.max(maxRow, count);
                    // 초기화
                    count = 1;
                }
            }

            // 마지막으로 확인한 부분 갱신 필요
            maxRow = Math.max(maxRow, count);
        }
        return maxRow;
    }

    // 열
    private static int findMaxCol() {
        int maxCol = 0;

        for(int col=0; col<n; col++) {
            int count = 1;
            for(int row=1; row<n; row++) {
                // 연속된 게 있는지 확인
                if(map[row][col] == map[row-1][col]) {
                    count ++;
                }else {
                    // 갱신
                    maxCol = Math.max(maxCol, count);
                    // 초기화
                    count = 1;
                }
            }

            // 마지막으로 확인한 부분 갱신 필요
            maxCol = Math.max(maxCol, count);
        }
        return maxCol;
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
