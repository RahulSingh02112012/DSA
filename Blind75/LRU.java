package Tree.Blind75;

import java.util.*;

public class LRU {

    private static void add(String key,Deque<String> dq) {
        dq.addFirst(key);
    }

    private static void remove(String key,Deque<String> dq) {
        dq.remove(key);
    }

    public static int get(String key, Map<String, Integer> map,Deque<String> dq) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key);
        remove(key,dq);
        add(key,dq);
        return val;
    }

    public static void put(String key, int value, Map<String, Integer> map, Deque<String> dq) {
        if (map.containsKey(key)) {
            remove(key,dq);
        } else if (map.size() >= 5) {
            String lruKey = dq.removeLast();
            map.remove(lruKey);
        }
        map.put(key, value);
        add(key,dq);
    }

    public static String  getLru(String[] strArr) {
        Deque<String> dq = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        int idx =0;

        for(int i=0;i<strArr.length;i++) {
            String key = strArr[i];
            int val = get(key,map,dq);
            if(val == -1) {
                put(key,idx,map,dq);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()) {
            sb.append(dq.pop()).append("-");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(getLru(new String[]{"A","B","A","C","A"}));
    }
}

