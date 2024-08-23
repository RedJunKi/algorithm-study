package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Burb_2449 {
    final static int INF = 1 << 30;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        int[] burbs = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            burbs[i] = Integer.parseInt(st.nextToken());

            if (burbs[i] == burbs[i - 1]) {
                burbs[i] = 0;
                N--;
                i--;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = INF;
            }
            dp[i][i] = 0;
        }

        for (int size = 2; size <= N; size++) {
            for (int start = 1; start <= N - size + 1; start++) {
                int end = start + size - 1;
                for (int mid = start; mid < end; mid++) {
                    int newValue = dp[start][mid] + dp[mid + 1][end];

                    if (burbs[start] != burbs[mid + 1]) {
                        newValue += 1;
                    }
                    dp[start][end] = Math.min(dp[start][end], newValue);
                }
            }
        }
        System.out.println(dp[1][N]);
    }
}
