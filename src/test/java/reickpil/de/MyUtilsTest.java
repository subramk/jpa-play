package reickpil.de;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import rieckpil.de.MyUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class MyUtilsTest {


    @Test
    void shouldMockStaticMethod() {

//        try (MockedStatic<MyUtils> mockedStatic = Mockito.mockStatic(MyUtils.class)) {
//
//            mockedStatic
//                    .when(() -> MyUtils.getWelcomeMessage(eq("duke"), anyBoolean()))
//                    .thenReturn("Howdy duke!");
//
//            String result = MyUtils.getWelcomeMessage("duke", false);
//
//            assertEquals("Howdy duke!", result);
//        }
    }
}
