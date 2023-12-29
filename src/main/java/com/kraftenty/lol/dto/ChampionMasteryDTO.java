package com.kraftenty.lol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@ToString
public class ChampionMasteryDTO {
    /**
     * championId	long	Champion ID for this entry.
     * championLevel	int	Champion level for specified player and champion combination.
     * championPoints	int	Total number of champion points for this player and champion combination - they are used to determine championLevel.
     */
    private Long championId;
    private Integer championLevel;
    private Integer championPoints;
}
