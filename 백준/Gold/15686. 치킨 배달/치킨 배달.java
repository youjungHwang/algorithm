import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int m;
    static int[][] map;
    static List<int[]> house;
    static List<int[]> chicken;
    static boolean[] visited;

    public static void main(String[] args) {
        String[] info = scan.nextLine().split(" ");
        n = Integer.parseInt(info[0]);
        // 살아남을 치킨집 수
        m = Integer.parseInt(info[1]);

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {

            String[] lineInfo = scan.nextLine().split(" ");
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(lineInfo[j-1]);

                if(map[i][j] == 2) {
                    chicken.add(new int[]{i,j});
                }

                if(map[i][j] == 1) {
                    house.add(new int[]{i,j});
                }
            }
        }

        // 치킨집 수 만큼 방문 배열 초기화
        visited = new boolean[chicken.size()];
        int answer = Integer.MAX_VALUE;
        answer = dfs(0, 0, answer);

        out.println(answer);

        // 자원 해제
        scan.close();
        out.close();
    }

    // 백트래킹
    private static int dfs(int start, int depth, int answer) {
        if (depth == m) {
            int result = 0;

            for (int[] h : house) {
                int hx = h[0];
                int hy = h[1];

                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {// 선택된 치킨집만 계산
                        int cx = chicken.get(i)[0];
                        int cy = chicken.get(i)[1];
                        int cal = Math.abs(cx - hx) + Math.abs(cy - hy);
                        min = Math.min(min, cal);
                    }
                }
                result += min;
            }
            // 최소 값을 계속 갱신
            return Math.min(answer, result);
        }

        // 조합으로 모든 치킨 집 확인
        for(int i=start; i<chicken.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer = dfs(i + 1, depth + 1, answer);
                visited[i] = false;
           }
        }
        return answer;
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


