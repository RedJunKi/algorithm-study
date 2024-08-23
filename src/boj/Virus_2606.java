package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Virus_2606 {
    private static int ans = 0;
    private static int N;
    private static int[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int connectCount = Integer.parseInt(br.readLine());
        visit = new int[N + 1];
        int[][] connectInfo = new int[N + 1][N + 1];

        for (int i = 1; i <= connectCount; i++) {
            String[] com = br.readLine().split(" ");
            int firstCom = Integer.parseInt(com[0]);
            int secondCom = Integer.parseInt(com[1]);
            connectInfo[firstCom][secondCom] = 1;
            connectInfo[secondCom][firstCom] = 1;

        }


        dfs(1, connectInfo);



        System.out.println(ans - 1);
        br.close();

    }

    private static void dfs(int position, int[][] connectInfo) {
        ans += 1;

        visit[position] = 1;

        for (int i = 1; i < connectInfo.length; i++) {
            if (visit[i] != 1 && connectInfo[position][i] == 1) {
                dfs(i, connectInfo);
            }
        }

    }
}
