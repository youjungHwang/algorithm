import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int m;
    static List<int[]> house;
    static List<int[]> chicken;
    static boolean[] visited;

    public static void main(String[] args) {
        String[] info = scan.nextLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        // 지도 입력 받기
        for (int i = 1; i <= n; i++) {
            String[] lineInfo = scan.nextLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(lineInfo[j - 1]);
                if (value == 2) {
                    chicken.add(new int[]{i, j});  // 치킨집
                }
                if (value == 1) {
                    house.add(new int[]{i, j});  // 집
                }
            }
        }

        // 치킨집 수 만큼 방문 배열 초기화
        visited = new boolean[chicken.size()];
        int answer = Integer.MAX_VALUE;

        // 백트래킹으로 최적의 치킨집 조합을 찾음
        answer = dfs(0, 0, answer);

        out.println(answer);  // 최종 결과 출력
        out.close();
    }

    // 백트래킹
    private static int dfs(int start, int depth, int answer) {
        if (depth == m) {
            int result = 0;

            // 집마다 최소 거리 계산
            for (int[] h : house) {
                int hx = h[0];
                int hy = h[1];

                int min = Integer.MAX_VALUE;
                // 선택된 치킨집만 계산
                for (int i = 0; i < chicken.size(); i++) {
                    if (visited[i]) {
                        int cx = chicken.get(i)[0];
                        int cy = chicken.get(i)[1];
                        int cal = Math.abs(cx - hx) + Math.abs(cy - hy);
                        min = Math.min(min, cal);  // 최소 거리로 갱신
                    }
                }
                result += min;  // 각 집의 최소 거리 합산
            }

            return Math.min(answer, result);  // 최소값을 계속 갱신
        }

        // 치킨집 선택
        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer = dfs(i + 1, depth + 1, answer);  // 조합 탐색
                visited[i] = false;
            }
        }

        return answer;  // 최종적으로 계산된 최소 거리 반환
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
