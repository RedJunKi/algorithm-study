package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hanoi_11729 {
    static int N;
    static int cnt = 0;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        hanoi(N, 1, 3, 2);

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int start, int end, int mid) {
        if (n == 0) {
            return;
        }


        hanoi(n - 1, start, mid, end);
        cnt++;
        sb.append(start).append(" ").append(end).append("\n");
        hanoi(n - 1, mid, end, start);

    }

}
