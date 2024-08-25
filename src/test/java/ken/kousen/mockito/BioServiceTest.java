package ken.kousen.mockito;

import ken.kousen.mockito.wikipedia.WikiUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

class BioServiceTest {
    @Test
    // Integration test
    void checkBios() {
        BioService service = new BioService("Anita Borg", "Ada Lovelace", "Grace Hopper", "Barbara Liskov");
        assertThat(service.getBios()).hasSize(4);
    }

    @Test
    @Disabled
    void testBioServiceWithMocks() {
        BioService service = new BioService("Anita Borg", "Ada Lovelace", "Grace Hopper", "Barbara Liskov");

        // Use mockStatic in a try-with-resources block
        try (MockedStatic<WikiUtil> mocked = mockStatic(WikiUtil.class)) {

            // Same when/then methods as a regular mock
            mocked.when(() -> WikiUtil.getWikipediaExtract(anyString()))
                .thenAnswer(invocation -> "Bio for " +
                    invocation.getArgument(0));

            assertThat(service.getBios()).hasSize(4);

            // Verify using a MockedStatic.Verification argument
            mocked.verify(() -> WikiUtil.getWikipediaExtract(
                anyString()), times(4));
        }
    }
}
