package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class NQueen_9663 {
    static int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N;
    static int M;
    static int cnt = 0;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] chess = new int[N];

        start(chess, 0);

        System.out.println(cnt);
    }

    private static void start(int[] chess, int row) {
        if (row == N) {
            System.out.println(Arrays.toString(chess));
            cnt++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col, chess)) {
                chess[row] = col;  // 퀸을 (row, col)에 놓음
                start(chess, row + 1);    // 다음 행으로 이동
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] chess) {
        for (int i = 0; i < row; i++) {
            if (chess[i] == col || Math.abs(chess[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
