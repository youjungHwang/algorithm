import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int[] visited;
    static int[] count;

    public static void main(String[] args) {
        // 최단시간 BFS+큐
        String[] info = scan.nextLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        // 초기화
        visited = new int[100001];
        count = new int[100001];

        chaseSister(n,k);

        out.println(visited[k]);
        out.println(count[k]);

        // 자원 해제
        scan.close();
        out.close();
    }

    private static void chaseSister(int n, int target) {
        // 큐
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        visited[n] = 0;
        count[n] = 1;

        while(!q.isEmpty()) {
            // 큐에서 원소 뽑고
            int curr = q.poll(); 

            // 종료 조건
            if(curr == target) break;

            int next[] = {curr-1, curr+1, curr*2}; 
            for(int i=0; i<next.length; i++) {
                // 범위 확인
                if(isRange(next[i])) {
                    // 첫 방문일 때
                    if(visited[next[i]] == 0) { 
                        visited[next[i]] = visited[curr] +1;
                        count[next[i]] = count[curr]; 
                        q.add(next[i]);

                    // 재 방문일 땐, 최단거리를 봐야하므로
                    }else if(visited[next[i]] == visited[curr] +1) {
                        count[next[i]] += count[curr];
                    }
                }
            }
        }
    }

    private static boolean isRange(int curr) {
        return 0 <= curr && curr <= 100000;
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


