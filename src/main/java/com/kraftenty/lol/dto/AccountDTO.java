package com.kraftenty.lol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@ToString
public class AccountDTO {
    private String puuid;
    private String gameName;
    private String tagLine;

}
