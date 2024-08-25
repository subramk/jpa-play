package java21.features.records;


/**
 * Java 21  - PatternMatching with  instanceof()
 * Java 17  - Switching on Types
 * Java ??  - Sealed Interfaces ( also can be done on classes ) , with a Permits clause.
 *
 */

public class PlayWithShape {

    public static void main(String[] args) {
        PlayWithShape shaper = new PlayWithShape();
        System.out.println( " cirlce" +  surface(new Circle(1d)));
    }

    public static double surface(final Shape shape){

        // PatternMatching in instanceof
        if(shape instanceof Circle circle){
            return Math.PI * circle.radius() * circle.radius();
        } else if ( shape instanceof  Square sq){
            return sq.edge()  * sq.edge() ;
        }
        return 0d;


    }

    // Earlier , we could ONLY switch on Integers, Strings and Enum.
    public static double surfaceWithSwitch(final Shape shape){

        return switch (shape) {
            case Circle circle -> Math.PI * circle.radius() * circle.radius();
            case Square square -> Math.PI * square.edge() * square.edge();
            // default -> 0d; // NOT required when we use Sealed Interfaces ,as only 2 shapes , Circle and Square
            // are permitted
        };
    }

    // Pattern Matching on Switch statement &&
    // Pattern Matching on Record
    public static double surfaceWithSwitchPatternMathing_and_RecordPatternMatching(final Shape shape){
        return switch (shape) {
            case Circle(double radius) -> Math.PI * radius * radius; // Circle(double radius )
            case Square(double edge)   -> edge * edge;
        };
    }

}
