package ru.siksmfp.spring.jms.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.siksmfp.spring.jms.consumer.entity.UserEntity;
import ru.siksmfp.spring.jms.consumer.service.UsersService;

import java.util.List;

/**
 * @author Artem Karnov @date 5/7/2018.
 * @email artem.karnov@t-systems.com
 */
@Controller
public class MainServletController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleHomePage(Model model) {
        List<UserEntity> all = usersService.getAll();
        model.addAttribute("result", all);
        return "home";
    }
}
