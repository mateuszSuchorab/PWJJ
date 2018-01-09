package zadaniaskryptjava;

import java.util.*;

public class StatementQueueHashMap {

    HashMap<String, Integer> hashMap = new HashMap();
    ArrayList<String> list = new ArrayList<String>();

    public synchronized void send(String key, int value) {
        hashMap.put(key, value);
        list.add(key);
    }

    public synchronized HashMap<String, Integer> collect() {
        if (hashMap.size() == 0) {
            return null;
        }

        HashMap<String, Integer> exit = new HashMap();//(hashMap);
        exit.put(list.get(0), hashMap.get(list.get(0)));
        hashMap.remove(list.get(0));
        list.remove(0);
        return exit;
    }
}
