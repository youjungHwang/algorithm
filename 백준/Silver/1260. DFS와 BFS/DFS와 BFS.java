import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int m;
    static int v;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    static List<Integer> resultList;

    public static void main(String[] args) {
        String[] info = scan.nextLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);
        v = Integer.parseInt(info[2]);

        // 그래프 초기화(각 노드에 리스트 생성)
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 그래프 생성
        for(int i=0; i<m; i++) {
            String[] line = scan.nextLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 노드번호 오름차순 정렬
        for(List<Integer> links : graph.values()) {
            Collections.sort(links);
        }

        // dfs
        visited = new boolean[n+1];
        resultList = new ArrayList<>();
        dfs(v);
        for(int num : resultList) {
            out.print(num + " ");
        }
        out.println();

        // bfs
        visited = new boolean[n+1];
        resultList = new ArrayList<>();
        bfs(v);
        for(int num : resultList) {
            out.print(num + " ");
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    // dfs + 재귀
    private static void dfs(int start) {
        resultList.add(start);
        visited[start] = true;

        // 연결된 노드
        for(int next : graph.get(start)) {
            // 방문 안한 노드인지 확인
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    // bfs + 큐
    private static void bfs(int start) {
        // 큐
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        visited[start] = true;
        resultList.add(start);

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int near : graph.get(curr)) {
                if(!visited[near]) {
                    visited[near] = true; // 방문 확인
                    q.add(near);
                    resultList.add(near); // 리스트 삽입
                }
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


