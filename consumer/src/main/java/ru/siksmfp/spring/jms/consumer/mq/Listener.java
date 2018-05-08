package ru.siksmfp.spring.jms.consumer.mq;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.siksmfp.spring.jms.consumer.service.UsersService;
import ru.siksmfp.spring.jms.dto.entity.UserDto;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

/**
 * @author Artem Karnov @date 5/8/2018.
 * @email artem.karnov@t-systems.com
 */
@Component
public class Listener {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Listener.class);

    @Autowired
    private UsersService usersService;

    @JmsListener(destination = "${queue.queue1}")
    public void receiveMessage(Message message) throws JMSException {
        LOGGER.info("Received message " + message);
        if (message instanceof ObjectMessage) {
            usersService.save((UserDto) ((ObjectMessage) message).getObject());
        }
    }
}