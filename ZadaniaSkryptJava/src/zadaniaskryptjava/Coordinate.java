package zadaniaskryptjava;

import java.util.*;

class Coordinate implements Comparable<Coordinate> {

    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Coordinate other) {
        if (this.x == other.x && this.y == other.y) {
            return 0;
        } else if ((other.x + other.y) > (this.x + this.y)) {
            return -1;
        } else {
            return 1;

        }

    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Coordinate)) {
            return false;
        }

        Coordinate coordinate = (Coordinate) o;

        return x == coordinate.x
                && Objects.equals(y, coordinate.y);

    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
