package zadaniaskryptjava;

import java.util.*;
import java.util.regex.Pattern;

class Graph {

    private int n; // liczba wierzchołków, V = {0,1,...,n-1}
    private LinkedList[] tab; // tablica wierzchołków połączonych z danym wierzcholkiem

    public Graph(String lan) {
        StringTokenizer st = new StringTokenizer(lan, "() ,");
        n = Integer.parseInt(st.nextToken());
        tab = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            tab[i] = new LinkedList();
        }
        while (st.hasMoreTokens()) {
            tab[Integer.parseInt(st.nextToken())].add(
                    new Integer(st.nextToken()));
        }
    }

    public String toString() {
        String result = "";

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            result += String.valueOf(i) + ": ";
            for (int j = 0; j < String.valueOf(tab[i]).length(); j++) {
                switch (String.valueOf(tab[i]).charAt(j)) {
                    case '[':
                    case ']':
                    case ',':
                        break;
                    default:
                        sb.append(String.valueOf(tab[i]).charAt(j));
                }
            }
            result += sb.toString() + "\n";

        }
        return result;
    }

}
