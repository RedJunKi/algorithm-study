package programmers;

public class LV2_2023kakaoRecruitment_emoticon {

    private static final int[] DISCOUNTS = {10, 20, 30, 40};
    private int maxSubscribers = 0;
    private int maxRevenue = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, emoticons, new int[emoticons.length], users);
        return new int[]{maxSubscribers, maxRevenue};
    }

    private void dfs(int depth, int[] emoticons, int[] discounts, int[][] users) {
        if (depth == emoticons.length) {
            calculate(users, emoticons, discounts);
            return;
        }

        for (int discount : DISCOUNTS) {
            discounts[depth] = discount;
            dfs(depth + 1, emoticons, discounts, users);
        }
    }

    private void calculate(int[][] users, int[] emoticons, int[] discounts) {
        int subscribers = 0;
        int revenue = 0;

        for (int[] user : users) {
            int userDiscount = user[0];
            int userLimit = user[1];
            int totalPrice = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= userDiscount) {
                    totalPrice += emoticons[i] * (100 - discounts[i]) / 100;
                }
            }

            if (totalPrice >= userLimit) {
                subscribers++;
            } else {
                revenue += totalPrice;
            }
        }

        if (subscribers > maxSubscribers || (subscribers == maxSubscribers && revenue > maxRevenue)) {
            maxSubscribers = subscribers;
            maxRevenue = revenue;
        }
    }
}
