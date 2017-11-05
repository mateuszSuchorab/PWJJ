package zadaniaskryptjava;

public class Rational {

    private int numerator;
    private int denominator;
    private boolean sign;

    Rational() {
        this.numerator = 0;
        this.denominator = 0;
        this.sign = true;
    }

    Rational(int numerator, int denominator) {
        this.sign = true;
        if (numerator < 0) {
            setSing();
        }
        this.numerator = Math.abs(numerator);
        if (denominator < 0) {
            setSing();
        }
        this.denominator = Math.abs(denominator);
    }

    Rational(int numerator, int denominator, boolean sing) {
        this.numerator = Math.abs(numerator);
        this.denominator = Math.abs(denominator);
        this.sign = sing;
    }

    public void setNumerator(int numerator) {

        this.numerator = Math.abs(numerator);
    }

    public void setDenominator(int denominator) {

        this.denominator = Math.abs(denominator);
    }

    public void setSing() {
        if (sign == true) {
            sign = false;
        } else {
            sign = true;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public boolean getSing() {
        return sign;
    }

    public Rational addition(Rational arg) {
        Rational replacementRational = new Rational(numerator, denominator, sign);
        if (replacementRational.getSing() == arg.getSing()) {
            replacementRational.sign = true;
            if (replacementRational.getDenominator() == arg.getDenominator()) {
                replacementRational.setNumerator(replacementRational.getNumerator() + arg.getNumerator());
            } else {

                replacementRational.setNumerator(replacementRational.getNumerator() * arg.getDenominator() + arg.getNumerator() * replacementRational.getDenominator());
                replacementRational.setDenominator((replacementRational.getDenominator() * arg.getDenominator()));

            }
        } else {
            if (replacementRational.getSing() == false) {
                replacementRational.setSing();
            } else {
                arg.setSing();
            }
            replacementRational = replacementRational.subtraction(arg);
        }
        return replacementRational;
    }

    public Rational subtraction(Rational arg) {
        Rational replacementRational = new Rational(numerator, denominator, sign);
        if (replacementRational.getSing() == arg.getSing() && arg.getSing() == true) {

            if (replacementRational.getDenominator() == arg.getDenominator()) {
                if (replacementRational.getNumerator() >= arg.getNumerator()) {
                    replacementRational.setNumerator(replacementRational.getNumerator() - arg.getNumerator());
                } else {
                    replacementRational.setNumerator(arg.getNumerator() - replacementRational.getNumerator());
                    replacementRational.setSing();
                }
            } else {
                replacementRational.setNumerator(replacementRational.getNumerator() * arg.getDenominator());
                arg.setNumerator(arg.getNumerator() * replacementRational.getDenominator());
                replacementRational.setDenominator((replacementRational.getDenominator() * arg.getDenominator()));
                if (replacementRational.getNumerator() >= arg.getNumerator()) {
                    replacementRational.setNumerator(replacementRational.getNumerator() - arg.getNumerator());
                } else {
                    replacementRational.setNumerator(arg.getNumerator() - replacementRational.getNumerator());
                    replacementRational.setSing();
                }
            }
        } else if (replacementRational.getSing() == arg.getSing() && arg.getSing() == false) {
            if (replacementRational.getDenominator() == arg.getDenominator()) {
                if (replacementRational.getNumerator() >= arg.getNumerator()) {
                    replacementRational.setNumerator(replacementRational.getNumerator() - arg.getNumerator());
                } else {
                    replacementRational.setNumerator(arg.getNumerator() - replacementRational.getNumerator());
                    replacementRational.setSing();
                }
            } else {
                replacementRational.setNumerator(replacementRational.getNumerator() * arg.getDenominator());
                arg.setNumerator(arg.getNumerator() * replacementRational.getDenominator());
                replacementRational.setDenominator((replacementRational.getDenominator() * arg.getDenominator()));
                if (replacementRational.getNumerator() >= arg.getNumerator()) {
                    replacementRational.setNumerator(replacementRational.getNumerator() - arg.getNumerator());
                } else {
                    replacementRational.setNumerator(arg.getNumerator() - replacementRational.getNumerator());
                    replacementRational.setSing();

                }
            }
        } else {
            if (replacementRational.getSing() == false) {
                replacementRational.setSing();
            } else {
                arg.setSing();
            }
            replacementRational = replacementRational.addition(arg);
        }
        return replacementRational;
    }

    public Rational multiplication(Rational arg) {
        Rational replacementRational = new Rational(numerator, denominator, sign);

        replacementRational.setNumerator(replacementRational.getNumerator() * arg.getNumerator());
        replacementRational.setDenominator(replacementRational.getDenominator() * arg.getDenominator());
        if (replacementRational.getSing() == arg.getSing()) {
            replacementRational.sign = true;
        } else {
            replacementRational.sign = false;
        }
        return replacementRational;
    }

    public Rational division(Rational arg) {
        Rational replacementRational = new Rational(numerator, denominator, sign);

        replacementRational.setNumerator(replacementRational.getNumerator() * arg.getDenominator());
        replacementRational.setDenominator(replacementRational.getDenominator() * arg.getNumerator());
        if (replacementRational.getSing() == arg.getSing()) {
            replacementRational.sign = true;
        } else {
            replacementRational.sign = false;
        }
        return replacementRational;

    }

    public boolean equals(Rational arg) {
        Rational replacementRational = new Rational(numerator, denominator, sign);
        if (replacementRational.getSing() != arg.getSing()) {
            return false;
        } else if (replacementRational.getNumerator() * arg.getDenominator() == replacementRational.getDenominator() * arg.getNumerator()) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Rational arg) {
        Rational replacementRational = new Rational(numerator, denominator, sign);
        if (replacementRational.getSing() != arg.getSing()) {
            if (replacementRational.getSing() == true) {
                return 1;
            } else {
                return -1;
            }
        } else if (replacementRational.getSing() == true) {
            if (replacementRational.getDenominator() != arg.getDenominator()) {
                replacementRational.setNumerator(replacementRational.getNumerator() * arg.getDenominator());
                arg.setNumerator(replacementRational.getDenominator() * arg.getNumerator());
            }
            if (replacementRational.getNumerator() > arg.getNumerator()) {
                return 1;
            } else if (replacementRational.getNumerator() == arg.getNumerator()) {
                return 0;
            } else {
                return -1;
            }

        } else {
            if (replacementRational.getDenominator() != arg.getDenominator()) {
                replacementRational.setNumerator(replacementRational.getNumerator() * arg.getDenominator());
                arg.setNumerator(replacementRational.getDenominator() * arg.getNumerator());
            }
            if (replacementRational.getNumerator() < arg.getNumerator()) {
                return 1;
            } else if (replacementRational.getNumerator() == arg.getNumerator()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public String toString() {
        Rational replacementRational = new Rational(numerator, denominator, sign);
        if (replacementRational.getSing() == true) {
            return replacementRational.getNumerator() + "/"+ replacementRational.getDenominator();
        } else {
            return "-"+replacementRational.getNumerator() + "/"+ replacementRational.getDenominator();
        }
        
    }
}
