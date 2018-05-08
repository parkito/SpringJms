package ru.siksmfp.spring.jms.consumer;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Message;
import javax.jms.TextMessage;

/**
 * @author Artem Karnov @date 5/8/2018.
 * @email artem.karnov@t-systems.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
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
