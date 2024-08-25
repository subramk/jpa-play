package ken.kousen.mockito;


/***
 * Excerpted from "Mockito Made Clear",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/mockito for more book information.
***/
public class HelloMockito {
    private String greeting = "Hello, %s, from Mockito!";

    public String greet(String name) {
        return String.format(greeting, name);
    }

}