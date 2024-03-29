package Tree.Zalando;

import java.util.*;

public class CodilityQuestion3 {
    public static void main(String[] args) {
        System.out.println(getMaxCanAttend(new String[]{"039","4","14","32","","34","7"}));
        System.out.println(getMaxCanAttend(new String[]{"801234567","180234567","0","189234567","891234567","98","9"}));
        System.out.println(getMaxCanAttend(new String[]{"5421","245","1452","0345","53","354"}));
    }

    private static int getMaxCanAttend(String[] strings) {
        Map<Integer,List<Integer>> availabilityMap = new HashMap<>();

        for(int i=0; i<10; i++) {
            // key - is day and value is number of employees that are free that day
            availabilityMap.put(i, new ArrayList<>());
        }

        for(int i =0;i<strings.length;i++) {
            String str = strings[i];

            for(int j=0; j<str.length(); j++) {
                int key = Character.getNumericValue(str.charAt(j));
                // availabilityMap.computeIfAbsent(key, k -> new ArrayList<>()).add(i);

                List<Integer> listTemp = availabilityMap.get(key);
                listTemp.add(i);
                availabilityMap.put(key, listTemp);
            }
        }

        int res = 0;

        Set<Integer> set = new HashSet<>();

        for(int i =0;i<10;i++) {
            List<Integer> list = availabilityMap.get(i);

            for(int j=i+1;j<10;j++) {
                set.addAll(list);
                if(availabilityMap.get(j) != null) {
                    set.addAll(availabilityMap.get(j));
                    res = Math.max(res,set.size());
                    set.clear();
                }
            }
        }

        return res;
    }

}
