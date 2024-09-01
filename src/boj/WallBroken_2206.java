package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WallBroken_2206 {
    static int N, M;
    static int[][] map;
    static int[][][] visited;
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();

        System.out.println(result);
    }

    private static int bfs() {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!Q.isEmpty()) {
            int[] position = Q.poll();
            int x = position[0];
            int y = position[1];
            int wallBroken = position[2];

            if (x == N - 1 && y == M - 1) {
                return visited[x][y][wallBroken];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];

                if (isInRange(nx, ny) && (map[nx][ny] == 0 && visited[nx][ny][0] == 0)) {

                    visited[nx][ny][wallBroken] = visited[x][y][wallBroken] + 1;
                    Q.add(new int[]{nx, ny, wallBroken});
                }

                if (isInRange(nx, ny) && (map[nx][ny] == 1 && wallBroken == 0 && visited[nx][ny][1] == 0)) {
                    visited[nx][ny][1] = visited[x][y][wallBroken] + 1;
                    Q.add(new int[]{nx, ny, 1});
                }
            }
        }
        return -1;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
