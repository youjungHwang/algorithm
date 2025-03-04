import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static Map<Integer, List<Edge>> graph = new HashMap<>();
    static int n;
    static int[] parent;

    public static void main(String[] args) {
        // 다익스트라
        n = scan.nextInt();
        int m = scan.nextInt();

        for(int i=0; i<m; i++) {
            String[] info = scan.nextLine().split(" ");

            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int dist = Integer.parseInt(info[2]);

            // 초기화
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());

            // 단방향 연결
            graph.get(start).add(new Edge(end, dist));
        }

        String[] info = scan.nextLine().split(" ");
        int finalStart = Integer.parseInt(info[0]);
        int finalEnd = Integer.parseInt(info[1]);

        int minDist = dijkstra(finalStart, finalEnd);
        out.println(minDist);

        List<Integer> path = findPath(finalStart, finalEnd);
        out.println(path.size());

        for(int num : path) {
            out.print(num + " ");
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    private static int dijkstra(int start, int end) {
        // 최대로 초기화한 distance 배열
        int MAX = Integer.MAX_VALUE;
        int[] distance = new int[n+1];
        Arrays.fill(distance, MAX);

        // 경로추적 배열
        parent = new int[n+1];
        Arrays.fill(parent, -1);

        // 우선순위 큐에 start 넣기
        Queue<Entry> pq = new PriorityQueue<>();
        pq.add(new Entry(start, 0));
        // 시작이므로 거리가 0
        distance[start] = 0;

        while(!pq.isEmpty()) {
            // 우선순위 큐에서 제일 작은 거 뽑는다
            Entry curr = pq.poll();

            // 현재 노드까지의 거리 > 이미 계산된 거리 -> continue
            if(curr.dist > distance[curr.nodeNum]) continue;

            // 현재 노드와 연결된 모든 정점을 돌면서 확인
            for(Edge edge : graph.get(curr.nodeNum)) {
                // 새 거리 = 현재 노드까지의 거리 + 연결된 정점의 거리
                int newDist = curr.dist + edge.dist;

                // 만약 새 거리 < 목표 노드까지의 기존 거리 -> 갱신 -> 우선순위 큐 삽입
                if(newDist < distance[edge.to]) {
                    distance[edge.to] = newDist;
                    pq.add(new Entry(edge.to, newDist));
                    // edge.to 노드로 가기위한 직전 노드 curr.nodeNum
                    parent[edge.to] = curr.nodeNum;
                }
            }
        }
        return distance[end];
    }

    private static List<Integer> findPath(int start, int end) {
        List<Integer> path = new ArrayList<>();

        for(int i=end; i != -1; i = parent[i]) {
            path.add(i);
        }

        // 경로 순서 뒤집기
       Collections.reverse(path);
        return path;
    }

    private static class Edge {
        private int to;
        private int dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    private static class Entry implements Comparable<Entry> {
        private int nodeNum;
        private int dist;

        public Entry(int nodeNum, int dist) {
            this.nodeNum = nodeNum; // 현재 노드
            this.dist = dist; // 현재 노드'까지' 최소 거리
        }

        @Override
        public int compareTo(Entry o) {
            // 거리기준 오름차순
            return Integer.compare(this.dist, o.dist);
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


