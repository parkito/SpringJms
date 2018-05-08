package ru.siksmfp.spring.jms.publisher;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.siksmfp.spring.jms.publisher.mq.config.BrokerServiceConfig;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author Artem Karnov @date 5/7/2018.
 * @email artem.karnov@t-systems.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context.xml"})
public class MqTest {

    private final static String TEST_QUEUE = "testQueue";
    private final static String TEST_MESSAGE_STRING = "This is a text message!";

    @Autowired
    protected JmsTemplate mJmsTestTemplate;

    @Test
    public void successSendAndReceiverMessage() throws Exception {
        mJmsTestTemplate.send(TEST_QUEUE,
                session -> {
                    final TextMessage theTextMessage = new ActiveMQTextMessage();
                    theTextMessage.setText(TEST_MESSAGE_STRING);
                    return theTextMessage;
                });

        final Message theMessage = mJmsTestTemplate.receive(TEST_QUEUE);

        Assert.assertNotNull(theMessage);
        Assert.assertTrue(theMessage instanceof TextMessage);
        final TextMessage theTextMessage = (TextMessage) theMessage;
        Assert.assertEquals(TEST_MESSAGE_STRING, theTextMessage.getText());
    }
}
