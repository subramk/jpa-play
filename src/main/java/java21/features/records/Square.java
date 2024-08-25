package java21.features.records;

public record Square(double edge) implements  Shape{

    public double surface() {
        return 0;
    }
}
