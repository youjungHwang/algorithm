import java.util.*;
import java.io.*;

class TreeNode {
    int value;
    List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        children = new ArrayList<>();
    }
}
public class Main {
    // 노드 배열
    private static TreeNode[] tree;

    // 출력 : 부모 배열
    private static int[] parents;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());

       // 초기화
       tree = new TreeNode[n+1];
       parents = new int[n+1];

       for(int i=1; i<=n; i++) {
           tree[i] = new TreeNode(i);
       }

       for(int i=0; i<n-1; i++) {
           String[] data = br.readLine().split(" ");
           int first = Integer.parseInt(data[0]);
           int second = Integer.parseInt(data[1]);

           tree[first].children.add(tree[second]);
           tree[second].children.add(tree[first]);
       }

       boolean[] visited = new boolean[n+1];
       findParent(1, visited);

       // 출력
       for(int i=2; i<=n; i++) {
           System.out.println(parents[i]);
       }
    }

    // dfs
    private static void findParent(int start, boolean[] visited) {
        visited[start] = true;

        for(TreeNode child : tree[start].children) {
            if(!visited[child.value]) {
                parents[child.value] = start;
                findParent(child.value, visited);
            }
        }
    }
}
