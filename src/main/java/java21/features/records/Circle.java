package java21.features.records;

public record Circle(double radius) implements  Shape{

    public double surface() {
        return Math.PI * radius * radius;
    }

}
