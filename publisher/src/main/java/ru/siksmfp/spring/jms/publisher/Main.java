package ru.siksmfp.spring.jms.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.siksmfp.spring.jms.publisher.entity.UserEntity;
import ru.siksmfp.spring.jms.publisher.mq.Publisher;
import ru.siksmfp.spring.jms.publisher.service.UsersService;

import java.util.List;

@Component
public class Main {
    @Autowired
    private Publisher publisher;

    @Autowired
    private UsersService usersService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
        ctx.getBean(Main.class).startApp();
    }

    private void startApp() {
        List<UserEntity> allUsers = usersService.getAll();

        for (UserEntity user : allUsers) {
            publisher.send(user);
        }
    }
}
