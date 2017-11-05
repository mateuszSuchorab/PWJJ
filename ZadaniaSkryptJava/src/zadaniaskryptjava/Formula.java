package zadaniaskryptjava;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Formula {

    private TreeVertex root;

    private TreeVertex createTree(String w, int p, int q) throws IncorrectlyConstructedFormula {
        if (p == q) {

            if (Character.isDigit(w.charAt(p))) {
                return new Constant(Character.digit(w.charAt(p), 10));
            } else {
                System.out.println("Gowno");
                throw new IncorrectlyConstructedFormula();
            }

        } else {
            int i = p + 1;
            int brackets = 0;
            while ((brackets != 0) || (w.charAt(i) == '(') || (w.charAt(i) == ')') || (Character.isDigit(w.charAt(i)))) {
                if (w.charAt(i) == '(') {
                    brackets++;
                }
                if (w.charAt(i) == ')') {
                    brackets--;
                }
                ++i;
            }

            Calculation neww = new Calculation(w.charAt(i));
            if ((p + 1 <= i - 1) && (i + 1 <= q - 1) && (Character.isDigit(w.charAt(i + 1))) || w.charAt(i + 1) == '(' || w.charAt(i + 1) == ')') {

                neww.addLeftArg(createTree(w, p + 1, i - 1));
                neww.addRightArg(createTree(w, i + 1, q - 1));
            } else {
                throw new IncorrectlyConstructedFormula();
            }
            return neww;
        }

    }

    public Formula(String w) throws IncorrectlyConstructedFormula {
        int brackets = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                brackets++;
            }
            if (w.charAt(i) == ')') {
                brackets--;
            }
        }
        if (brackets == 0) {
            root = createTree(w, 0, w.length() - 1);
        } else {
            throw new IncorrectlyConstructedFormula();
        }
    }

    public int calculation() throws DivisionByZero, IncorrectlyConstructedFormula {
        return root.value();
    }
}
