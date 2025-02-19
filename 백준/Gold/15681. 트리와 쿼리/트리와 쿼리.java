import java.io.*;
import java.util.*;

class TreeNode{
    int value;
    List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
}
public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static TreeNode[] tree;
    static boolean[] visited;
    static int[] sum;

    public static void main(String[] args) {
        // 트리 + dfs
        String[] info = scan.nextLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int root = Integer.parseInt(info[1]);
        int q = Integer.parseInt(info[2]);

        // 트리 초기화
        tree = new TreeNode[n+1];
        for(int i=1; i<=n; i++) {
            tree[i] = new TreeNode(i);
        }

        // 트리 생성
        for(int i=0; i<n-1; i++) {
            String[] nodeInfo = scan.nextLine().split(" ");
            int first = Integer.parseInt(nodeInfo[0]);
            int second = Integer.parseInt(nodeInfo[1]);

            tree[first].children.add(tree[second]);
            tree[second].children.add(tree[first]);
        }

        // 초기화
        visited = new boolean[n+1];
        sum = new int[n+1];

        sum[root] = getSum(root);

        for(int i=0; i<q; i++) {
            int startNode = scan.nextInt();
            out.println(sum[startNode]);
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    private static int getSum(int startNode) {
        visited[startNode] = true;
        int count = 1;

        // 이미 계산된 값이 있다면 재활용
        if(sum[startNode] != 0) {
            return sum[startNode];
        }

        for(TreeNode child : tree[startNode].children) {
            if(!visited[child.value]) {
                count += getSum(child.value);
            }
        }

        sum[startNode] = count;
        return sum[startNode];
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
