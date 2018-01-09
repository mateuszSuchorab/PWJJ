package zadaniaskryptjava;

import java.util.*;

class MyThread extends Thread {

    private StatementQueue koko;
    private int istart;

    public MyThread(StatementQueue koko, int istart) {
        this.koko = koko;
        this.istart = istart;
    }

    public void run() {
        try {
            for (int i = istart; i <= 10; i += 2) {
                koko.send(new Integer(i));
                               
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
        };
    }
}
