package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fibonacci6_11444 {
    private static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        if (n == 0) {
            System.out.println(0);
        } else {
            long result = fibonacci(n - 1);
            System.out.println(result);
        }
    }

    private static long fibonacci(long n) {
        long[][] matrix = {
                {1, 1},
                {1, 0}
        };
        long[][] result = matrixPower(matrix, n);
        return result[0][0];
    }

    private static long[][] matrixPower(long[][] base, long exp) {
        long[][] result = {
                {1, 0},
                {0, 1}
        };

        //지수가 홀수일때는 result에 저장 A * A²
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiplyMatrices(result, base);
            }
            //지수가 짝수일때는 A² * A²
            base = multiplyMatrices(base, base);
            exp /= 2;
        }
        return result;
    }

    private static long[][] multiplyMatrices(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return result;
    }

}
