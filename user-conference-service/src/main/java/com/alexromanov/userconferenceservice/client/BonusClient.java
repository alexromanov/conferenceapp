package com.alexromanov.userconferenceservice.client;

import java.util.List;

import com.alexromanov.userconferenceservice.model.UserBonus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "bonus-conference-service", path = "/bonus-conference-service")
public interface BonusClient {
    @GetMapping("/userBalance")
    public List<UserBonus> getBonusBalanceForUser(@RequestParam("userId") long userId, @RequestParam("sessionId") long sessionId);
}
