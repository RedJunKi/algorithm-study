package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC_5430 {
    static int T;
    static String function;
    static int numSize;
    static Deque<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            function = br.readLine();
            numSize = Integer.parseInt(br.readLine());
            String originalArr = br.readLine();
            arr = parseArr(originalArr);

            boolean isReversed = false;
            boolean isError = false;

            for (char func : function.toCharArray()) {
                if (func == 'R') {
                    isReversed = !isReversed;
                } else if (func == 'D') {
                    if (arr.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isReversed) {
                        arr.pollLast();
                    } else {
                        arr.pollFirst();
                    }
                }
            }
            if (isError) {
                System.out.println("error");
            } else {
                printDeque(arr, isReversed);
            }
        }
    }

    private static void printDeque(Deque<Integer> arr, boolean isReversed) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!arr.isEmpty()) {
            if (isReversed) {
                sb.append(arr.pollLast());
            } else {
                sb.append(arr.pollFirst());
            }

            if (!arr.isEmpty()) {
                sb.append(",");
            }
        }

        sb.append("]");
        System.out.println(sb);
    }


    private static Deque<Integer> parseArr(String originalArr) {
        Deque<Integer> result = new ArrayDeque<>();
        String substring = originalArr.substring(1, originalArr.length() - 1);
        String[] splitArr = substring.split(",");

        for (int i = 0; i < numSize; i++) {
            result.add(Integer.parseInt(splitArr[i]));
        }
        return result;
    }
}
