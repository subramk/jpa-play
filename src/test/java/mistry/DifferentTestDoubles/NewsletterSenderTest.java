package mistry.DifferentTestDoubles;

import mistry.DifferentTestDoubles.src.main.java.MessagingEngine;
import mistry.DifferentTestDoubles.src.main.java.NewsletterSender;
import mistry.DifferentTestDoubles.src.main.java.SubscribersDatabase;
import mistry.DifferentTestDoubles.src.main.java.ZeroSubscribersException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class NewsletterSenderTest {

    @Test
    public void constructorAssignsDatabase(){

        MessagingEngine messagingEngine = mock(MessagingEngine.class);
        SubscribersDatabase subscribersDatabase = new SubscribersDatabase();
        NewsletterSender newsletterSender = new NewsletterSender(subscribersDatabase, messagingEngine);

        assertEquals(subscribersDatabase, newsletterSender.getSubscribersDatabase());
    }

    @Test
    public void numberOfSubscribers(){

        SubscribersDatabase subscribersDatabaseMock = mock(SubscribersDatabase.class);
        MessagingEngine messagingEngineMock = mock(MessagingEngine.class);

        NewsletterSender sender = new NewsletterSender(subscribersDatabaseMock, messagingEngineMock);

        List<String> subscribersList = Arrays.asList("email1", "email2", "email3");
        when(subscribersDatabaseMock.getSubscribers()).thenReturn(subscribersList);

        assertEquals(3, sender.numberOfSubscribers());
    }

    @Test
    public void expectZeroSubscribersThrown()
    {
        Exception zeroSubscribersException = assertThrows(
                ZeroSubscribersException.class, () -> {
                    NewsletterSender newsletterSender = new NewsletterSender(new SubscribersDatabase(), new MessagingEngine());
                    NewsletterSender newsletterSenderSpy = spy(newsletterSender);
                    when(newsletterSenderSpy.numberOfSubscribers()).thenReturn(0);
                    newsletterSenderSpy.sendNewsletter("SUBJECT");
                }
        );
    }
}
