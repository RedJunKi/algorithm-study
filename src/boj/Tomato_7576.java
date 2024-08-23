package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7576 {

    private static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Queue<int[]> queue = new LinkedList<>();


        int[][] tomatos = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatos[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatos[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs(tomatos, queue, N, M);

        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatos[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxValue = Math.max(maxValue, tomatos[i][j]);
            }
        }

        System.out.println(maxValue - 1);

    }

    private static void bfs(int[][] tomatos, Queue<int[]> queue, int n, int m) {
        int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (tomatos[nx][ny] == 0) {
                    tomatos[nx][ny] = tomatos[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
