import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N = 4;
    static int M = 6;
    static int[] riceArr;
    static int max;
    public static void main(String[] args) throws IOException {
        riceArr = new int[]{19, 15, 10, 17};
        Arrays.sort(riceArr);
        int start = 0;
        int end = riceArr[N - 1];
        int result = 0;

        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (riceArr[i] > mid) {
                    total += riceArr[i] - mid;
                }
            }
            if (total < M) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
