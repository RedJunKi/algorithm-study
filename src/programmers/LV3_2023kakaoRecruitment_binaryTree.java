package programmers;

public class LV3_2023kakaoRecruitment_binaryTree {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;

        for (long number : numbers) {
            String str = Long.toBinaryString(number);
            int n = 0;

            // 현재 2진수 문자열의 길이가 2의 몇승인지 확인
            while (str.length() > (int) Math.pow(2, n) - 1) {
                n++;
            }
            // 2의 n승만큼 더미 숫자를 앞에 채워준다
            while (str.length() < (int) Math.pow(2, n) - 1) {
                str = "0" + str;
            }

            int result = 1;
            if (!isPossible(str, str.length() / 2, n - 1)) {
                result = 0;
            }
            answer[idx++] = result;
        }
        return answer;
    }

    private boolean isPossible(String str, int now, int level) {
        if (level == 0) {
            return true;
        }

        int child1 = now + (int) Math.pow(2, level - 1);
        int child2 = now - (int) Math.pow(2, level - 1);

        if (str.charAt(now) == '0') {
            if (str.charAt(child1) == '1' || str.charAt(child2) == '1') {
                return false;
            }
        }

        if (!isPossible(str, child1, level - 1)) {
            return false;
        }

        if (!isPossible(str, child2, level - 1)) {
            return false;
        }

        return true;
    }
}
