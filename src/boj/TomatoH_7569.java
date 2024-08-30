package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TomatoH_7569 {
    static int M;
    static int N;
    static int H;
    static int[][][] map;
    static int[][] direction = {{1, 0, 0}, {0, 1, 0}, {-1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        q.add(new int[]{h, n, m});
                    }
                }
            }
        }


        bfs(q);

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        max = Math.max(max, map[h][n][m]);
                    }
                }
            }
        }

        System.out.println(max - 1);
    }

    private static void bfs(Queue<int[]> q) {

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int h = poll[0];
            int n = poll[1];
            int m = poll[2];

            for (int i = 0; i < 6; i++) {
                int nh = h + direction[i][2];
                int nn = n + direction[i][0];
                int nm = m + direction[i][1];

                if (isInRange(nn, nm, nh) && map[nh][nn][nm] == 0) {
                    map[nh][nn][nm] = map[h][n][m] + 1;
                    q.add(new int[]{nh, nn, nm});
                }
            }
        }
    }

    private static boolean isInRange(int x, int y, int z) {

        return x >= 0 && x < N && y >= 0 && y < M && z >= 0 && z < H ;
    }

}