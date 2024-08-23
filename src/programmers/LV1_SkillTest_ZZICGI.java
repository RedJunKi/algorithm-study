package programmers;

import java.util.ArrayList;
import java.util.List;

public class LV1_SkillTest_ZZICGI {
    static class Solution {
        public int[] solution(int[] answers) {
            int[] firstPattern = {1, 2, 3, 4, 5};
            int[] secondPattern = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] thirdPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int score1 = 0;
            int score2 = 0;
            int score3 = 0;

            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == firstPattern[i % firstPattern.length]) {
                    score1++;
                }
                if (answers[i] == secondPattern[i % secondPattern.length]) {
                    score2++;
                }
                if (answers[i] == thirdPattern[i % thirdPattern.length]) {
                    score3++;
                }
            }

            int maxScore = Math.max(score1, (Math.max(score2, score3)));
            List<Integer> topScore = new ArrayList<>();

            if (maxScore == score1) {
                topScore.add(1);
            }
            if (maxScore == score2) {
                topScore.add(2);
            }
            if (maxScore == score3) {
                topScore.add(3);
            }

            return topScore.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
}
