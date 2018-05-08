package ru.siksmfp.spring.jms.publisher.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.siksmfp.spring.jms.dto.entity.UserDto;
import ru.siksmfp.spring.jms.publisher.entity.Role;
import ru.siksmfp.spring.jms.publisher.entity.UserEntity;

/**
 * @author Artem Karnov @date 5/7/2018.
 * @email artem.karnov@t-systems.com
 */
@Component
public class Publisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);

    @Value("${queue.queue1}")
    private String queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(UserEntity userEntity) {
        LOGGER.info("Sending {} to {}", userEntity, queue);
        jmsTemplate.send(queue, s -> s.createObjectMessage(convertUser(userEntity)));
    }

    private UserDto convertUser(UserEntity entity) {
        UserDto userDto = new UserDto();
        userDto.setEmail(entity.getEmail());
        userDto.setFirstName(entity.getFirstName());
        userDto.setSecondName(entity.getSecondName());
        userDto.setRole(convertRole(entity.getRole()));
        return userDto;
    }

    // TODO: 5/8/2018 It can be made much better
    private UserDto.Role convertRole(Role role) {
        switch (role) {
            case USER:
                return UserDto.Role.USER;
            case ADMIN:
                return UserDto.Role.ADMIN;
            case ROOT:
                return UserDto.Role.ROOT;
            default:
                return UserDto.Role.USER;
        }
    }

}
