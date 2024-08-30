package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MakePassword_1759 {
    static int L;
    static int C;
    static List<String> result;
    static char[] combination;
    static char[] candidate;
    static char[] vowel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        vowel = new char[]{'a', 'e', 'i', 'o', 'u'};

        result = new ArrayList<>();
        candidate = new char[C];
        combination = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            candidate[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(candidate);

        generateCombinations(0, 0);

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void generateCombinations(int start, int depth) {
        if (depth == L) {
            int vowelCnt = 0;
            int consonantCnt = 0;
            for (char c : combination) {
                if (isVowel(c)) {
                    vowelCnt++;
                } else {
                    consonantCnt++;
                }
            }

            if (vowelCnt >= 1 && consonantCnt >= 2) {
                result.add(new String(combination));
                return;
            }

            return;
        }

        for (int i = start; i < C; i++) {
            combination[depth] = candidate[i];
            generateCombinations(i + 1, depth + 1);

        }

    }

    private static boolean isVowel(char c) {
        for (char v : vowel) {
            if (c == v) {
                return true;
            }
        }
        return false;
    }
}
