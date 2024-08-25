package ken.kousen.mockito;

import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.util.List;


class ListOfTwoElements implements ArgumentMatcher<List> {
    public boolean matches(List list) {
        return list.size() == 2;
    }

    public String toString() {
        //printed in verification errors
        return "[list of 2 elements]";
    }

// create the mock
//    List mock = Mockito.mock(List.class);
//    // set the expectation using argThat and the custom matcher
//    Mockito.when(mock.addAll(argThat(new ListOfTwoElements()))).thenReturn(true);

//// somewhere in the actual test, test a method that invokes addAll

//// with a two-element list:
//    mock.addAll(Arrays.asList("one","two"));

//// verify that the test called addAll with the custom matcher
//    verify(mock).addAll(argThat(new ListOfTwoElements()));

}
