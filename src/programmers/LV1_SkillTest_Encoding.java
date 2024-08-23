package programmers;

public class LV1_SkillTest_Encoding {
    static class Solution {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        public String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int alphabetIndex = alphabet.indexOf(c);
                int count = 0;

                while (count < index) {
                    alphabetIndex = (alphabetIndex + 1) % alphabet.length();
                    if (!skip.contains(String.valueOf(alphabet.charAt(alphabetIndex)))) {
                        count++;
                    }
                }

                answer.append(alphabet.charAt(alphabetIndex));
            }

            return answer.toString();
        }
    }
}
