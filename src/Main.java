import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.solution("aukks", "wbqd", 5);
        System.out.println(result); // 예상 출력: "happy"
    }

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
