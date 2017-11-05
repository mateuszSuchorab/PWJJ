package zadaniaskryptjava;

public class LinearFunction implements Polynomial {

    private int a;
    private int b;

    
    public LinearFunction() {
    }

    
    public LinearFunction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public String getZeroOfAFunction() {
        return String.valueOf((-b) / a);
    }

}
