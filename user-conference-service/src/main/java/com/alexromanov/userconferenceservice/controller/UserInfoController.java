package com.alexromanov.userconferenceservice.controller;

import java.util.ArrayList;

import com.alexromanov.userconferenceservice.entity.ConferenceUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {
    private static final long VALID_USER_ID = 111111;

    @GetMapping("/user/{id}")
    public ConferenceUser getUserInformation(@PathVariable("id") long userId) {
        ConferenceUser user = ConferenceUser.builder().build();
        if (userId == VALID_USER_ID) {
            user.setId(userId);
            user.setName("Jack");
            user.setSurname("Ice");
            user.setBonuses(new ArrayList<>());
        }
        return user;
    }
}
