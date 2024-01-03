package com.kraftenty.lol.dto;

import lombok.*;

import java.util.Map;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
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
        private String id; // 영어이름
        private String key; // 숫자
        private String name; // 한국이름
        private String title; // 부가설명
    }

}
