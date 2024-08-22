package programmers;

import java.util.PriorityQueue;

public class LV2_2023kakaoRecruitment_Logistics_usePriorityQueue {

    long answer;

    class DistanceAndStuff {
        int dist;
        int stuff;

        public DistanceAndStuff(int dist, int stuff) {
            this.dist = dist;
            this.stuff = stuff;
        }
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        PriorityQueue<DistanceAndStuff> delivery = new PriorityQueue<>((o1, o2) -> o2.dist - o1.dist);
        PriorityQueue<DistanceAndStuff> pickup = new PriorityQueue<>((o1, o2) -> o2.dist - o1.dist);

        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                delivery.add(new DistanceAndStuff(i + 1, deliveries[i]));
            }
            if (pickups[i] != 0) {
                pickup.add(new DistanceAndStuff(i + 1, pickups[i]));
            }
        }

        while (!delivery.isEmpty() || !pickup.isEmpty()) {

            takeBox(cap, delivery, pickup);
        }

        return answer;
    }

    private void takeBox(int cap, PriorityQueue<DistanceAndStuff> delivery, PriorityQueue<DistanceAndStuff> pickup) {
        int dist = 0;

        dist = getDist(delivery, cap, dist);
        dist = getDist(pickup, cap, dist);

        answer += dist * 2;

    }

    private int getDist(PriorityQueue<DistanceAndStuff> stuffs, int cap, int dist) {
        while (!stuffs.isEmpty()) {
            if (cap <= 0) {
                break;
            }
            DistanceAndStuff stuff = stuffs.poll();
            dist = Math.max(dist, stuff.dist);
            if (stuff.stuff <= cap) {
                cap -= stuff.stuff;
                stuff.stuff = 0;
            } else {
                stuff.stuff -= cap;
                cap = 0;
                stuffs.add(stuff);
            }
        }
        return dist;
    }
}
