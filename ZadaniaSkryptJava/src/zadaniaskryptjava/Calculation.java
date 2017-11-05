package zadaniaskryptjava;

class Calculation extends TreeVertex {

    private char operator; // operator +, -, / lub *

    public Calculation(char operator) {
        this.operator = operator;
    }

    public void addLeftArg(TreeVertex arg) {
        left = arg;
    }

    public void addRightArg(TreeVertex arg) {
        right = arg;
    }

    @Override
    public int value() throws DivisionByZero {
        switch (operator) {
            case '+':
                return left.value() + right.value();
            case '-':
                return left.value() - right.value();
            case '/':
                if (right.value() == 0) {
                    throw new DivisionByZero();
                } else {
                    return left.value() / right.value();
                }
            case '*':
                return left.value() * right.value();
        }
        return 0;
    }
}
