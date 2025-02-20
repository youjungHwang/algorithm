import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    // 이동 방향
    static int[] dr = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dc = {1, 2, 2, 1, -1 ,-2, -2, -1};

    public static void main(String[] args) {
        int t = scan.nextInt();

        for(int i=0; i<t; i++) {
            int n = scan.nextInt();
            String[] curr = scan.nextLine().split(" ");
            int cx = Integer.parseInt(curr[0]);
            int cy = Integer.parseInt(curr[1]);

            String[] target = scan.nextLine().split(" ");
            int tx = Integer.parseInt(target[0]);
            int ty = Integer.parseInt(target[1]);

            int[][] map = new int[n][n];
            boolean[][] visited = new boolean[n][n];

           int min = shortestDist(map, cx, cy, tx, ty, visited, n);
           out.println(min);
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    // bfs
    private static int shortestDist(int[][]map, int cx, int cy, int tx, int ty,
                                    boolean[][] visited, int n) {
        // 큐
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{cx, cy, 0});
        visited[cx][cy] = true;

        while(!q.isEmpty()) {
            // 큐에서 원소 뽑기
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            int count = curr[2];

            // 종료 조건
            if(currX == tx && currY == ty) {
                return count;
            }

            // 8방향으로 돌면서 확인
            for(int i=0; i<8; i++) {
                int nextX = currX + dr[i];
                int nextY = currY + dc[i];

                if(isRange(nextX, nextY, n) && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new int[]{nextX, nextY, count +1});
                }
            }
        }
        // 여기까지 올 일 없음
        return -1;
    }

    // 범위 확인
    private static boolean isRange(int nextX, int nextY, int n) {
        return 0 <= nextX && nextX < n && 0 <= nextY && nextY < n;
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


