package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoboticVacuumCleaner_14503 {
    static int N, M, r, c, d;
    static int[][] map;
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(cnt);
    }

    private static void clean(int x, int y, int d) {
        while (true) {
            // 현재 칸 청소
            if (map[x][y] == 0) {
                map[x][y] = 2;
                cnt++;
            }

            boolean cleaned = false;

            // 네 방향을 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = x + direction[d][0];
                int ny = y + direction[d][1];

                if (map[nx][ny] == 0) {
                    // 청소되지 않은 빈 칸이 있으면 전진
                    x = nx;
                    y = ny;
                    cleaned = true;
                    break;
                }
            }

            // 네 방향 모두 청소가 이미 되어있거나 벽인 경우
            if (!cleaned) {
                int backDirection = (d + 2) % 4;
                int bx = x + direction[backDirection][0];
                int by = y + direction[backDirection][1];

                // 후진 가능하면 후진
                if (map[bx][by] != 1) {
                    x = bx;
                    y = by;
                } else {
                    // 후진이 불가능한 경우 작동 멈춤
                    break;
                }
            }
        }
    }
}
