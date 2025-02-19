import java.io.*;
import java.util.*;

class TreeNode {
    int value;
    List<Pair<TreeNode, Integer>> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}

class Pair<T, I> {
    T first;
    I second;

    public Pair(T first, I second) {
        this.first = first;
        this.second = second;
    }
}

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static TreeNode[] tree;
    static boolean[] visited;
    static int maxDist;
    static int farthestNode;

    public static void main(String[] args) {
        int v = scan.nextInt();

        // 트리 초기화
        tree = new TreeNode[v+1];
        for(int i=1; i<=v; i++) {
            tree[i] = new TreeNode(i);
        }

        // 트리 정점 연결
        for (int i = 0; i < v; i++) {
            int node = scan.nextInt();
            while (true) {
                int adj = scan.nextInt();
                if (adj == -1) break;
                int weight = scan.nextInt();
                tree[node].children.add(new Pair<>(tree[adj], weight));
            }
        }

        // 1번 정점에서 가장 긴 노드 찾기(dfs)
        visited = new boolean[v+1];
        maxDist = 0;
        dfs(1,0);

        // 1번 정점에서 가장 긴 노드에서 트리의 지름 찾기(dfs)
        visited = new boolean[v+1];
        maxDist = 0;
        dfs(farthestNode,0);

        System.out.print(maxDist);

        // 자원 해제
        scan.close();
        out.close();
    }

    private static void dfs(int node, int dist) {
        if(visited[node]) return;
        visited[node] = true; 

        if(dist > maxDist) {
            maxDist = dist; 
            farthestNode = node;
        }

        // 정점에 연결된 정점을 돌면서 maxDist, farthestNode 업데이트
        for(Pair<TreeNode, Integer> nextNode : tree[node].children) {
            dfs(nextNode.first.value, dist + nextNode.second);
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
