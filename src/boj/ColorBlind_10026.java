package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ColorBlind_10026 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][N];
        int normalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map[i][j]);
                    normalCount++;
                }
            }
        }

        visited = new boolean[N][N];
        int colorBlindCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfsColorBlind(i, j, map[i][j]);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);

    }

    private static void dfsColorBlind(int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];
            if (isInRange(nx, ny) && !visited[nx][ny] && isSameColor(color, map[nx][ny])) {
                dfsColorBlind(nx, ny, map[nx][ny]);
            }
        }
    }

    private static boolean isSameColor(char a, char b) {
        if (a == 'B' || b == 'B') return a == b;
        else return true;
    }

    private static void dfs(int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + direction[i][0];
            int ny = y + direction[i][1];

            if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }

    }

    private static boolean isInRange(int x, int y) {

        return x >= 0 && x < N && y >= 0 && y < N;
    }

}