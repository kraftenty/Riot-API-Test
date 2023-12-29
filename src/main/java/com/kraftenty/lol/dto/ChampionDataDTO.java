package com.kraftenty.lol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;


@Getter @Setter
@AllArgsConstructor
@ToString
public class ChampionDataDTO {

    private Map<String, ChampionDTO> data;

    @Getter
    public static class ChampionDTO {
        /**
         * "id": "Aatrox",
         * "key": "266",
         * "name": "아트록스",
         * "title": "다르킨의 검",
         */
        private String id;
        private String key;
        private String name;
        private String title;
    }

}
