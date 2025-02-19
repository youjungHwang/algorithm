import java.io.*;
import java.util.*;

class TreeNode {
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
    static int n;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) {
        n = scan.nextInt();

        // 트리 초기화
        tree = new TreeNode[n+1];
        for(int i=1; i<=n; i++) {
            tree[i] = new TreeNode(i);
        }

        // 트리 생성
        for(int i=0; i<n-1; i++) {
            String[] info = scan.nextLine().split(" ");
            int first = Integer.parseInt(info[0]);
            int second = Integer.parseInt(info[1]);

            tree[first].children.add(tree[second]);
            tree[second].children.add(tree[first]);
        }

        // 방문 배열 초기화
        visited = new boolean[n+1];
        parents = new int[n+1];
        findParentNode(1);

       for(int i=2; i<n+1; i++) {
           System.out.println(parents[i]);
       }

        // 자원 해제
        scan.close();
        out.close();
    }

    private static void findParentNode(int curr) {
        visited[curr] = true;

        for(TreeNode child : tree[curr].children) {
            if(!visited[child.value]) {
                parents[child.value] = curr;
                findParentNode(child.value); 
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
