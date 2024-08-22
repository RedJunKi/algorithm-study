package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNum_BinarySearch_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] nArray = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArray);

        int m = Integer.parseInt(br.readLine());
        int[] mArray = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArray[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int target = mArray[i];

            result[i] = findTargetInArray(nArray, target, 0, nArray.length - 1);
        }

        Arrays.stream(result)
                .forEach(System.out::println);
    }
    private static int findTargetInArray(int[] nArray, int target, int start, int end) {
        if (start > end) {
            return 0;
        }

        int mid = (start + end) / 2;

        if (nArray[mid] == target) {
            return 1;
        } else if (nArray[mid] > target) {
            return findTargetInArray(nArray, target, start, mid - 1);
        } else {
            return findTargetInArray(nArray, target, mid + 1, end);
        }
    }
}
