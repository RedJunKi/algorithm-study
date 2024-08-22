package programmers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LV1_2023kakaoRecruitment {
    public int[] solution(String today, String[] terms, String[] privacies) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate formatToday = LocalDate.parse(today, formatter);

        Map<String, Integer> rule = new HashMap<>();
        List<Integer> result = new ArrayList<>();


        Arrays.stream(terms)
                .forEach(t -> {
                    String[] term = t.split(" ");
                    rule.put(term[0], Integer.parseInt(term[1]));
                });

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            Integer term = rule.get(privacy[1]);
            LocalDate privacyDate = LocalDate.parse(privacy[0], formatter);
            if (privacyDate.getDayOfMonth() == 1) {
                privacyDate = privacyDate.minusMonths(1).withDayOfMonth(28);
            } else {
                privacyDate = privacyDate.minusDays(1);
            }
            LocalDate contractDate = privacyDate.plusMonths(term);

            if (formatToday.isAfter(contractDate)) {
                result.add(i + 1);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
