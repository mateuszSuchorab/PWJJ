package zadaniaskryptjava;

public class QuadraticFunction implements Polynomial {

    private int a;
    private int b;
    private int c;

    public QuadraticFunction() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public QuadraticFunction(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int calculateY(int x) {
        return a * x * x + b * x + c;

    }

    public int numbeOfRoots() {
        int delta = (b*b)- (4 * a * c);
        if (delta < 0) {
            return 0;
        } else if (delta == 0) {
            return 1;
        } else {
            return 2;
        }

    }

    @Override
    public String getZeroOfAFunction() {
        int delta = (b*b)- (4 * a * c); 
        double result;
        double result2;
        if (delta < 0) {
            return "zero";
        } else if (delta == 0) {
            result = -b/2*a;
            return String.valueOf(result);
        } else {
            result = (-b-Math.sqrt(delta))/(2*a);
            result2 = (-b+Math.sqrt(delta))/(2*a);
             return String.valueOf(result)+ " " + String.valueOf(result2);
        }
         
    }

}
