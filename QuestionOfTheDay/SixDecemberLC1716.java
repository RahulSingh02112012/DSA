package Tree.QuestionOfTheDay;

import java.util.HashMap;
import java.util.Map;

public class SixDecemberLC1716 {
    public static void main(String[] args) {
        System.out.println(totalMoney(10));
    }

    public static int totalMoney(int n) {
        Map<Integer,Integer> balance = new HashMap<>();

        for(int i =1; i<=n ;i++) {
            int dayOfWeek = i % 7;
            if (dayOfWeek == 0)
            {
                dayOfWeek = 7;
            }
               int currBalance = balance.getOrDefault(dayOfWeek,0);

            switch (dayOfWeek) {
                case 1:
                    balance.put(dayOfWeek,currBalance+1);
                    break;

                case 2:
                    balance.put(dayOfWeek,currBalance+balance.getOrDefault(dayOfWeek-1,0)+1);
                    break;

                case 3:
                    balance.put(dayOfWeek,currBalance-balance.get(1)+balance.getOrDefault(dayOfWeek-1,0)+1);
                    break;

                case 4:
                    balance.put(dayOfWeek,currBalance+balance.getOrDefault(dayOfWeek-1,0)+1);
                    break;

                case 5:
                    balance.put(dayOfWeek,currBalance+balance.getOrDefault(dayOfWeek-1,0)+1);
                    break;

                case 6:
                    balance.put(dayOfWeek,currBalance+balance.getOrDefault(dayOfWeek-1,0)+1);
                    break;

                default:
                    balance.put(dayOfWeek,currBalance+balance.getOrDefault(dayOfWeek-1,0)+1);
            }
        }
        return balance.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
