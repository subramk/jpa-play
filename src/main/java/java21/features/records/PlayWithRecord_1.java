package java21.features.records;

import java.util.List;

public class PlayWithRecord_1 {

    record Range(int begin, int end, List<Integer> values ){
        // Canonical Constructor
        Range(int begin, int end, List<Integer> values){

            if ( end < begin){
                throw new IllegalStateException(" should not be the case ");
            }
            this.begin = begin ;
            this.end = end ;
            this.values = List.copyOf(values); // defensive Copy
        }
    }

    public static void main(String[] args) {

        Range range  = new Range(0,5 , List.of(1,2,3)  );
        System.out.println(" Range =  " + range );
        System.out.println(" Begin  = " + range.begin() + ".... end = " + range.end() );

    }

}
