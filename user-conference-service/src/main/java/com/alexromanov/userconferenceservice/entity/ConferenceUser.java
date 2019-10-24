package com.alexromanov.userconferenceservice.entity;

import java.util.List;

import com.alexromanov.bonusconferenceservice.entity.Bonus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConferenceUser {
    private long id;
    private String name;
    private String surname;
    private List<Bonus> bonuses;
}
