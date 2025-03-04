import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static Map<Integer, List<Edge>> graph = new HashMap<>();
    public static void main(String[] args) {
        // 최소신장트리 - 프림 알고리즘
        int n = scan.nextInt();
        int m = scan.nextInt();

        for(int i=0; i<m; i++) {
            String[] info = scan.nextLine().split(" ");

            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            int dist = Integer.parseInt(info[2]);

            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());

            graph.get(start).add(new Edge(end, dist));
            graph.get(end).add(new Edge(start, dist));
        }

        // 시작 노드 1번
        int mstWeight = prim(1, n);
        out.println(mstWeight);

        // 자원 해제
        scan.close();
        out.close();
    }

    // 다익스트라
    private static int prim(int start, int end) {
        final int INF = Integer.MAX_VALUE;

        // 최소신장트리의 가중치 합
        int mstWeight = 0;

        // 최소 거리를 갱신할 distance 배열
        int[] distance = new int[graph.size() +1];
        Arrays.fill(distance, INF);

        // 우선순위 큐
        Queue<Entry> pq = new PriorityQueue<>();
        pq.add(new Entry(start, 0));
        // 처음 시작이므로 거리가 0
        distance[start] = 0;

        // 최소 신장 트리에 포함된 노드 체크
        boolean[] inMST = new boolean[end + 1];

        while (!pq.isEmpty()) {
            Entry curr = pq.poll();

            // 이미 MST에 포함된 노드라면 무시
            if (inMST[curr.nodeNum]) continue;

            // 현재 노드를 MST에 포함
            inMST[curr.nodeNum] = true;
            mstWeight += curr.dist; 

            // 현재 노드에 연결된 모든 엣지를 확인
            for (Edge edge : graph.get(curr.nodeNum)) {
                if (!inMST[edge.to] && edge.dist < distance[edge.to]) {
                    // 해당 노드가 MST에 포함되지 않고, 현재 가중치보다 작은 간선이 있으면 갱신
                    distance[edge.to] = edge.dist;
                    pq.add(new Entry(edge.to, edge.dist));
                }
            }
        }

        return mstWeight;
    }

    // to(목적지)로 가는데 dist(거리)
    static class Edge {
        private int to;
        private int dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    // nodeNum(현재 노드 번호), dist(해당 노드까지 최소 거리)
    static class Entry implements Comparable<Entry> {
        private int nodeNum;
        private int dist;

        public Entry(int nodeNum, int dist) {
            this.nodeNum = nodeNum;
            this.dist = dist;
        }

        @Override
        public int compareTo(Entry o) {
            // 오름차순 정렬
            return this.dist - o.dist;
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



