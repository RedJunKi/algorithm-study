import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N = 3;
    static int M = 4;
    static int[][] arr;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        arr = new int[][]{{1, 3, 3, 2}, {2, 1, 4, 1}, {0, 6, 4, 8}};
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = arr[i][j];
            }
        }

        for (int j = 1; j < M; j++) {
            for (int i = 0; i < N; i++) {
                int up, down, center;
                if (i - 1 < 0) {
                    up = Integer.MIN_VALUE;
                } else {
                    up = arr[i - 1][j];
                }

                if (i + 1 >= N) {
                    down = Integer.MIN_VALUE;
                } else {
                    down = arr[i + 1][j];
                }

                center = arr[i][j];

                result[i][j] = result[i][j]+ Math.max(up, Math.max(down, center));
            }
        }
        int r = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                r = Math.max(r, result[i][k]);
            }
        }
        System.out.println(r);
    }
}