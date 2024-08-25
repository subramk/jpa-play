package java21.features.records;

public sealed interface Shape permits Circle,Square {

    // Without Sealed Interfaces , in old way Java ( prior to sealed interfaces )
    // All classes that implement Shape() must override the surface() method.
    // This violates the Solid principles of - interface segregation and Single Responsibility pattern
    // What IF a particluar Shape CLASS  does NOT need the surface() method but needs other methods ...etc  -
    //  L I S K O V

    // When Sealed Classes / Interfaces , come  into the picture now , specifying exactly WHICH subClasses need to
    // override the method

     double surface();


}
