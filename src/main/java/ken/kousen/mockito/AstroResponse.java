package ken.kousen.mockito;

import java.util.List;

public class AstroResponse {
    private final int number;
    private final String message;
    private final List<Assignment> people;

   // constructors, getters and setters, toString
    public AstroResponse(int number, String message, List<Assignment> people) {
        this.number = number;
        this.message = message;
        this.people = people;
    }
}
