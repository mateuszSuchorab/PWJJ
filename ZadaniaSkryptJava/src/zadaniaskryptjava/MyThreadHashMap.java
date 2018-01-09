package zadaniaskryptjava;

import java.util.*;

public class MyThreadHashMap extends Thread {

    private StatementQueueHashMap koko;
    private int istart;

    public MyThreadHashMap(StatementQueueHashMap koko, int istart) {
        this.koko = koko;
        this.istart = istart;
    }

    public void run() {

        try {
            for (int i = istart; i <= 10; i += 2) {
                koko.send(String.valueOf(i), i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
        };
    }
}
