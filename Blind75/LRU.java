package Tree.Blind75;

import java.util.*;

public class LRU {
    static Map<String, Integer> map;
    static Deque<String> dq;

    private static void add(String key) {
        dq.addFirst(key);
    }

    private static void remove(String key) {
        dq.remove(key);
    }

    public static int get(String key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key);
        remove(key);
        add(key);
        return val;
    }

    public static void put(String key, int value) {
        if (map.containsKey(key)) {
            remove(key);
        } else if (map.size() >= 5) {
            String lruKey = dq.removeLast();
            map.remove(lruKey);
        }
        map.put(key, value);
        add(key);
    }

    public static String  getLru(String[] strArr) {
        dq = new ArrayDeque<>();
        map = new HashMap<>();
        int idx =0;

        for(int i=0;i<strArr.length;i++) {
            String key = strArr[i];
            int val = get(key);
            if(val == -1) {
                put(key,idx);
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

