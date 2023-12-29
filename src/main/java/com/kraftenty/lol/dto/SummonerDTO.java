package com.kraftenty.lol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@ToString
public class SummonerDTO {

//    private String id;
//    private String accountId;
//    private Long revisionDate;
//    private String puuid;

    private Integer profileIconId;
    private String name;
    private Long summonerLevel;

}
