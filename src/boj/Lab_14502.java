package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab_14502 {
    static int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N;
    static int M;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] labMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                labMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(0, labMap);


        System.out.println(max);

    }

    private static void dfs(int cnt, int[][] labMap) {
        if (cnt == 3) {
            int[][] tmp = new int[N][M];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = labMap[i].clone();

            }
            bfs(tmp);
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (labMap[i][j] == 0) {
                    labMap[i][j] = 1;
                    dfs(cnt+1, labMap);
                    labMap[i][j] = 0;
                }
            }
        }
    }


    private static void bfs(int[][] tmp) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                if (tmp[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0];
            int y = position[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + direction[i][0];
                int ny = y + direction[i][1];

                if (isInRange(nx, ny) && tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int cnt = 0;

        for (int[] row : tmp) {
            for (int e : row) {
                if (e == 0) {
                    cnt++;
                }
            }
        }

        max = Math.max(cnt, max);
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
