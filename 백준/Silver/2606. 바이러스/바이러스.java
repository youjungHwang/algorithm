import java.util.*;
import java.io.*;

public class Main {
    // 그래프
    private static List<List<Integer>> graph;

    // 방문 확인
    private static boolean[] visited;

    // 바이러스 걸린 컴퓨터 수
    private static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=m; i++) {
            String[] info = br.readLine().split(" ");
            int x = Integer.parseInt(info[0]);
            int y = Integer.parseInt(info[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 방문 확인 배열 초기화
        visited = new boolean[n+1];

        findVirusCount(1);

        System.out.print(count);
    }

    private static void findVirusCount(int node) {
        // 방문 확인
        visited[node] = true; 

        for(int near : graph.get(node)) { 
            if(!visited[near]) {
                count++; 
                findVirusCount(near);
            }
        }
    }
}
