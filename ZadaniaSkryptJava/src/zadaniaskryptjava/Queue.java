package zadaniaskryptjava;

 class Queue {

    static final int N = 5;
    private Object[] tab;
    private int beginning, theLastOne, label;

    public Queue() {
        beginning = 0;
        theLastOne = 0;
        label = 0;
        tab = new Object[N];
    }

    void toQueue(Object el) throws Insufficiency {
        if (theLastOne + 1 == N) {
            throw new Insufficiency();
        } else {
            tab[theLastOne] = el;
            theLastOne = (theLastOne + 1) % N;
            ++label;
        }
    }

    Object fromQueue() throws Overflow {
        if (beginning == theLastOne) {
            throw new Overflow();
        } else {
            int ind = beginning;
            beginning = (beginning + 1) % N;
            --label;
            return tab[ind];
        }
    }
}
