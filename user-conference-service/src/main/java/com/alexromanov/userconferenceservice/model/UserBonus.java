package com.alexromanov.userconferenceservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBonus {
    private long id;
    private String type;
}
