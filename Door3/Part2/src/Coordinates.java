import java.util.Objects;

public class Coordinates implements Comparable<Coordinates>{

    private int y;
    private int x;
    private int steps;

    public Coordinates(int y, int x, int steps) {
        this.y = y;
        this.x = x;
        this.steps = steps;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return y == that.y &&
                x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }


    @Override
    public int compareTo(Coordinates o) {
        return ((this.x+this.y)-(o.x+o.y));
    }
}
