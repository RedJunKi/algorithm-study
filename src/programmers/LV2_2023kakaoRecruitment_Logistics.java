package programmers;

public class LV2_2023kakaoRecruitment_Logistics {

    public static void main(String[] args) {
        LV2_2023kakaoRecruitment_Logistics lv22023kakaoRecruitment = new LV2_2023kakaoRecruitment_Logistics();
        long result = lv22023kakaoRecruitment.solution(2, 7, new int[]{1, 0, 2, 0, 1, 0, 2}, new int[]{0, 2, 0, 1, 0, 2, 0});
        System.out.println(result);
    }

    /**
     * Greedy
     * 배달하고 돌아오는길에 수거한다.
     * 제일 먼 집에 배달하고 거리를 저장
     */

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryIndex = n - 1;

        while (deliveryIndex >= 0) {
            int currentCap = cap;
            int distance = 0;

            while (deliveryIndex >= 0 && deliveries[deliveryIndex] == 0) {
                deliveryIndex--;
            }

            if (deliveryIndex >= 0) {
                distance = Math.max(distance, deliveryIndex + 1);
            }

            while (deliveryIndex >= 0 && currentCap > 0) {
                if (deliveries[deliveryIndex] <= currentCap) {
                    currentCap -= deliveries[deliveryIndex];
                    deliveries[deliveryIndex] = 0;
                    deliveryIndex--;
                } else {
                    deliveries[deliveryIndex] -= currentCap;
                    currentCap = 0;
                }
            }

//            currentCap = cap;
//
//            while (pickupIndex >= 0 && pickups[pickupIndex] == 0) {
//                pickupIndex--;
//            }
//
//            if (pickupIndex >= 0) {
//                distance = Math.max(distance, pickupIndex + 1);
//            }
//
//            while (pickupIndex >= 0 && currentCap > 0) {
//                if (pickups[pickupIndex] <= currentCap) {
//                    currentCap -= pickups[pickupIndex];
//                    pickups[pickupIndex] = 0;
//                    pickupIndex--;
//                } else {
//                    pickups[pickupIndex] -= currentCap;
//                    currentCap = 0;
//                }
//            }

            answer += distance * 2;
        }

        return answer;
    }
}
