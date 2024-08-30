package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ChickenDistance_15686 {
    static int N;
    static int M;
    static int[][] map;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickenShops = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickenShops.add(new int[]{i, j});
                }
            }
        }

        int result;
        List<int[]> selected = new ArrayList<>();
        result = getMinChickenDistance(0, 0, selected);

        System.out.println(result);


    }

    private static int getMinChickenDistance(int idx, int cnt, List<int[]> selected) {
        if (cnt == M) {
            return calculateCityChickenDistance(selected);
        }

        if (idx >= chickenShops.size()) {
            return Integer.MAX_VALUE;
        }

        selected.add(chickenShops.get(idx));
        int choose = getMinChickenDistance(idx + 1, cnt + 1, selected);
        selected.remove(selected.size() - 1);

        int notChoose = getMinChickenDistance(idx + 1, cnt, selected);

        return Math.min(choose, notChoose);
    }

    private static int calculateCityChickenDistance(List<int[]> selected) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;
            for (int[] chickenShop : selected) {
                int distance = Math.abs(house[0] - chickenShop[0]) + Math.abs(house[1] - chickenShop[1]);
                minDistance = Math.min(minDistance, distance);
            }
            totalDistance += minDistance;
        }
        return totalDistance;
    }
}
