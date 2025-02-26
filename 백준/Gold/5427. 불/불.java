import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    // 4방향
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // 현재 불, 1초 뒤 불이 붙은 방으로는 갈 수 없다 -> 불 먼저 이동 후 상근이 이동
    public static void main(String[] args) {
        int t = scan.nextInt();

        for(int i=0; i<t; i++) {
            String[] info = scan.nextLine().split(" ");
            int y = Integer.parseInt(info[0]);
            int x = Integer.parseInt(info[1]);

            char[][] map = new char[x][y];

            // 상근이 이동 시간
            int[][] visited = new int[x][y];
            // 불 이동 시간
            int[][] fire = new int[x][y];

            initializeMap(map, x, y);

            bfs(map, x, y, visited, fire);
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    // bfs
    private static void bfs(char[][] map, int x, int y, int[][] visited, int[][] fire) {
        String answer = "IMPOSSIBLE";

        // 큐 2개 사용
        Queue<int[]> fireQ = new ArrayDeque<>();
        Queue<int[]> personQ = new ArrayDeque<>();

        // 큐에 현재 상근이와 불의 위치를 넣기
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                if(map[i][j] == '*') {
                    fireQ.add(new int[]{i,j});
                    // 주어진 위치도 1초로 체크
                    fire[i][j] = 1;

                }
                if(map[i][j] == '@') {
                    personQ.add(new int[]{i,j});
                    // 주어진 위치도 1초로 체크
                    visited[i][j] = 1;
                }
            }
        }

        // [첫번째] 지도 끝까지 불을 지른다
        while(!fireQ.isEmpty()) {
            int[] currF = fireQ.poll();
            int currFX = currF[0];
            int currFY = currF[1];

            for(int i=0; i<4; i++) {
                int nextFX = currFX + dr[i];
                int nextFY = currFY + dc[i];

                if(isRange(nextFX, nextFY, x, y) && fire[nextFX][nextFY] == 0 && map[nextFX][nextFY] != '#') {
                    fire[nextFX][nextFY] = fire[currFX][currFY] + 1;
                    fireQ.add(new int[]{nextFX, nextFY});
                }
            }
        }

        // [두번째] 상근이 이동
        boolean isEscaped = false;
        while(!personQ.isEmpty()) {
            int[] currP = personQ.poll();
            int currPX = currP[0];
            int currPY = currP[1];

            // 현재 위치에서 탈출 가능한지 확인
            if(isExit(currPX, currPY, x, y)) {
                isEscaped = true;
                out.println(visited[currPX][currPY]);
                break;
            }

            for(int i=0; i<4; i++) {
                int nextPX = currPX + dr[i];
                int nextPY = currPY + dc[i];

                if(isRange(nextPX, nextPY, x, y) && visited[nextPX][nextPY] == 0 && map[nextPX][nextPY] != '#') {
                    // 기존 불이 도착한 시간보다 먼저 가야 함
                    if(fire[nextPX][nextPY] == 0 || fire[nextPX][nextPY] > visited[currPX][currPY] + 1) {
                        visited[nextPX][nextPY] = visited[currPX][currPY] + 1;
                        personQ.add(new int[]{nextPX, nextPY});
                    }
                }
            }
        }

        if(!isEscaped) {
            out.println(answer);
        }
    }

    // initializeMap 지도 초기화
    private static void initializeMap(char[][] map, int x, int y) {
        for(int i=0; i<x; i++) {
            String info = scan.nextLine();
            for(int j=0; j<y; j++) {
                map[i][j] = info.charAt(j);
            }
        }
    }

    // isRange 지도 안에 있는지 확인
    private static boolean isRange(int currX, int currY, int x, int y) {
        return 0 <= currX && currX < x && 0 <= currY && currY < y;
    }

    // isExit 탈출 가능한지 확인
    private static boolean isExit(int currX, int currY, int x, int y) {
        return currX == 0  || currX == x-1 || currY == 0 || currY == y-1;
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


