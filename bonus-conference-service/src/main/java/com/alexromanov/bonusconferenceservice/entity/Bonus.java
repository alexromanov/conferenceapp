package com.alexromanov.bonusconferenceservice.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bonus {
	private long id;
	private String type;
}
