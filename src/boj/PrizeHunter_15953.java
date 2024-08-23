package boj;

import java.util.Arrays;
import java.util.Scanner;

public class PrizeHunter_15953 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] first_prizeList = new int[][]{
            {1, 500}, {3, 300}, {6, 200}, {10, 50}, {15, 30}, {21, 10}
        };
        int[][] second_prizeList = new int[][]{
            {1, 512}, {3, 256}, {7, 128}, {15, 64}, {15, 30}, {31, 32}
        };


        int tryCount = Integer.parseInt(sc.nextLine());
        int[] result = new int[tryCount];
        for (int i = 0; i < tryCount; i++) {
            int totalPrize = 0;
            String[] grades = sc.nextLine().split(" ");
            totalPrize += calculatePrize(Integer.parseInt(grades[0]), first_prizeList);
            totalPrize += calculatePrize(Integer.parseInt(grades[1]), second_prizeList);
            result[i] = totalPrize * 10000;
        }

        Arrays.stream(result)
                .forEach(System.out::println);
    }

    private static int calculatePrize(int grade, int[][] prizeList) {
        if (grade == 0) {
            return 0;
        }

        for (int[] ints : prizeList) {
            if (grade <= ints[0]) {
                return ints[1];
            }
        }
        return 0;
    }
}
