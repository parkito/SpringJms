package ru.siksmfp.spring.jms.consumer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.siksmfp.spring.jms.consumer.entity.UserEntity;
import ru.siksmfp.spring.jms.consumer.service.UsersService;

import java.util.List;

@Component
public class Main {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Main.class);

    @Autowired
    private UsersService usersService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
        ctx.getBean(Main.class).startApp();
    }

    private void startApp() {
        List<UserEntity> allUsers = usersService.getAll();
        for (UserEntity user : allUsers) {
            LOGGER.info(user.toString());
        }
    }
}
