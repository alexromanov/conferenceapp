package com.alexromanov.userconferenceservice.controller;

import java.util.List;

import com.alexromanov.userconferenceservice.client.BonusClient;
import com.alexromanov.userconferenceservice.entity.ConferenceUser;
import com.alexromanov.userconferenceservice.model.UserBonus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserInfoController {
    private static final long VALID_USER_ID = 111111;

    private final BonusClient bonusClient;

    @GetMapping("/user/{id}")
    public ConferenceUser getUserInformation(@PathVariable("id") long userId) {
        ConferenceUser user = ConferenceUser.builder().build();
        List<UserBonus> userBonuses = bonusClient.getBonusBalanceForUser(userId, 111);
        if (userId == VALID_USER_ID) {
            user.setId(userId);
            user.setName("Jack");
            user.setSurname("Ice");
            user.setBonuses(userBonuses);
        }
        return user;
    }
}
