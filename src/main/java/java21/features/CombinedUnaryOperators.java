package java21.features;

import java.util.List;
import java.util.function.IntUnaryOperator;

/*
        Take a Integer
        Add 1 to the Number
        Multiply result of the above  by 2
        Add 3 to the Result of the above.

 */
public class CombinedUnaryOperators {

    public static void main(String[] args) {
        doWork();

    }


    // UnaryOperator Represents an operation on a single int-valued operand that produces an int-valued result.
    // This is the primitive type specialization of UnaryOperator for int.
    //This is a functional interface whose functional method is applyAsInt(int).

    private static void doWork() {

        // we have a list of unary operators
        // 1st unary operator adds 1 to the input and returns an in.
        // 2nd unary operator multiplies 2 to the input returned above.
        // 3rd unary operator adds 3 to the input returned above.

        List<IntUnaryOperator>  unaryOperators  =
                List.of(i -> i + 1 ,
                        i -> i * 2 ,
                        i -> i + 3);

        // basic
        IntUnaryOperator unnn1 =  unaryOperators
                                .stream()
                                .reduce( i -> i , (op1, op2) -> op1.andThen(op2));

        System.out.println ( unnn1.applyAsInt(5) ) ;

        // Using  andThen
        IntUnaryOperator unnn2 =  unaryOperators
                .stream()
                .reduce( i -> i , IntUnaryOperator::andThen);

        System.out.println ( unnn2.applyAsInt(5) ) ;


        // using identity();
        IntUnaryOperator unnn3 =  unaryOperators
                .stream()
                .reduce( IntUnaryOperator.identity() , IntUnaryOperator::andThen);
                //.reduce( identity() , IntUnaryOperator::andThen);


        System.out.println ( unnn3.applyAsInt(5) ) ;






    }


}
