import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수

        for (int t = 0; t < T; t++) {
            int I = sc.nextInt(); // 체스판의 크기
            boolean[][] visited = new boolean[I][I];
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();

            System.out.println(bfs(I, startX, startY, endX, endY, visited));
        }
    }

    static int bfs(int I, int startX, int startY, int endX, int endY, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (x == endX && y == endY) {
                return count;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < I && ny < I && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, count + 1});
                }
            }
        }
        return -1; // 이론상으로는 여기에 도달하지 않음
    }
}
