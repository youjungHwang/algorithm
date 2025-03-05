import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static int result;

    public static void main(String[] args) {
        // dfs
        n = scan.nextInt();
        int m = scan.nextInt();

        // 그래프 초기화
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            String[] info = scan.nextLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);

            // 그래프 양방향 연결
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        // 방문 배열 초기화
        visited = new boolean[n+1];
        dfs(1);

        out.print(result);

        // 자원 해제
        scan.close();
        out.close();
    }

    // dfs
    private static void dfs(int s) {
        // 방문 확인
        visited[s] = true;

        // 연결된 노드 확인
        for(int near : graph.get(s)) {
            if(!visited[near]) {
                result ++;
                dfs(near);
            }
        }
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


