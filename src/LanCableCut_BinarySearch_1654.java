import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LanCableCut_BinarySearch_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lanCables = new int[k];
        for (int i = 0; i < k; i++) {
            lanCables[i] = Integer.parseInt(br.readLine());
        }

        long low = 1;
        long high = 0;
        for (int length : lanCables) {
            if (length > high) {
                high = length;
            }
        }

        long result = 0;
        while (low <= high) {
            long mid = (low + high) / 2;

            long count = 0;
            for (int length : lanCables) {
                count += length / mid;
            }

            if (count >= n) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}
