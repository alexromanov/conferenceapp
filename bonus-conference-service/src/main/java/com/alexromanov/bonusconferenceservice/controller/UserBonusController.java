package com.alexromanov.bonusconferenceservice.controller;

import com.alexromanov.bonusconferenceservice.entity.Bonus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserBonusController {
	@GetMapping("/userBalance")
	public List<Bonus> getUserBonus(@RequestParam("userId") long userId, @RequestParam("sessionId") long sessionId){
		Bonus userBonus = Bonus.builder()
				.id(111111)
				.type("TICKET")
				.build();

		List<Bonus> bonuses = new ArrayList<>();
		if (userBonus.getId() == userId){
			bonuses.add(userBonus);
		}
		return bonuses;
	}
}
