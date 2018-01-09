package zadaniaskryptjava;

import java.util.*;

class StatementQueue {

    Vector queue = new Vector();

    public synchronized void send(Object ob) {
        queue.addElement(ob);
    }

    public synchronized Object collect() {
        if (queue.size() == 0) {
            return null;
        }
        Object ob = queue.firstElement();
        queue.removeElementAt(0);
        return ob;
    }
}
