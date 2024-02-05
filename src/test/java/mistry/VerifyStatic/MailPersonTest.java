package mistry.VerifyStatic;

import org.junit.jupiter.api.Test;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(MailEngine.class)
public class MailPersonTest{


    @Test
    public void testSendIsCalled(){
//        MailEngine mailEngineMock = mock(MailEngine.class);
//        MailPerson mailPerson = new MailPerson(mailEngineMock);
//
//        mailPerson.deliverMail("ABC");
//        verify(mailEngineMock).send();
    }

    @Test
    public void testSendMailStaticCalled(){
//        PowerMockito.mockStatic(MailEngine.class);
//        MailPerson mailPerson = new MailPerson(new MailEngine());
//        mailPerson.deliverMail("ABD");
//
//        PowerMockito.verifyStatic(MailEngine.class, Mockito.times(2));
//        MailEngine.sendMailToABD();
    }
}