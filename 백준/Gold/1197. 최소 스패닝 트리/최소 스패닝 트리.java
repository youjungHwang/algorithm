import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static Map<Integer, List<Edge>> graph = new HashMap<>();
    static int v;
    static int e;
    public static void main(String[] args) {
        String[] info = scan.nextLine().split(" ");
        v = Integer.parseInt(info[0]);
        e = Integer.parseInt(info[1]);

        for(int i=0; i<e; i++) {
            String[] infoE = scan.nextLine().split(" ");
            int start = Integer.parseInt(infoE[0]);
            int end = Integer.parseInt(infoE[1]);
            int dist = Integer.parseInt(infoE[2]);

            // 초기화
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());

            // 양방향
            graph.get(start).add(new Edge(end, dist));
            graph.get(end).add(new Edge(start, dist));
        }

        int mstWeight = prim(1,v);
        out.print(mstWeight);

        // 자원 해제
        scan.close();
        out.close();
    }

    private static int prim(int start, int end) {
        int MAX = Integer.MAX_VALUE;
        int[] distance = new int[v+1];
        Arrays.fill(distance, MAX);

        // 최소신장트리 가중치 합
        int mstWeight = 0;

        // 우선순위 큐
        Queue<Entry> pq = new PriorityQueue<>();
        pq.add(new Entry(start, 0));
        distance[start] = 0;

        // 방문 확인
        boolean[] visited = new boolean[v+1];

        while(!pq.isEmpty()) {
            Entry curr = pq.poll();

            // 이미 방문한 노드라면 무시
            if(visited[curr.nodeNum]) continue;

            // 현재 노드를 방문
            visited[curr.nodeNum] = true;
            mstWeight += curr.dist;

            // 현재 노드에 연결된 엣지 확인
            for(Edge edge : graph.get(curr.nodeNum)) {
                if(!visited[edge.to] && edge.dist < distance[edge.to]) {
                    distance[edge.to] = edge.dist;
                    pq.add(new Entry(edge.to, edge.dist));
                }
            }
        }

        return mstWeight;
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
        private int nodeNum; // 현재 노드
        private int dist; // 현재노드 까지의 최소 거리

        public Entry(int nodeNum, int dist) {
            this.nodeNum = nodeNum;
            this.dist = dist;
        }

        @Override
        public int compareTo(Entry o) {
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


