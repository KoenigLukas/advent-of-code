public class ManhattenCoordinates {

    private Direction direction;
    private int steps;

    public ManhattenCoordinates(Direction direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "ManhattenCoordinates{" +
                "direction=" + direction +
                ", steps=" + steps +
                '}';
    }
}
