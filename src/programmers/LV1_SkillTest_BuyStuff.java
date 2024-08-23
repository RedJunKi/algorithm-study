package programmers;

import java.util.Arrays;

public class LV1_SkillTest_BuyStuff {
    public class Solution {

        public int solution(int[] d, int budget) {
            // 부서별 요청 금액을 오름차순으로 정렬
            Arrays.sort(d);

            int total = 0;
            int count = 0;

            // 작은 금액부터 예산이 허용할 때까지 더해나간다
            for (int i = 0; i < d.length; i++) {
                total += d[i];
                if (total > budget) {
                    break; // 예산을 초과하면 중지
                }
                count++; // 지원 가능한 부서 수 증가
            }

            return count;
        }
    }
}
