package com.alexromanov.userconferenceservice.entity;

import java.util.List;

import com.alexromanov.userconferenceservice.model.UserBonus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConferenceUser {
    private long id;
    private String name;
    private String surname;
    private List<UserBonus> bonuses;
}
