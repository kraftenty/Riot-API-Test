package com.kraftenty.lol.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChampionImgService {

    private final BasicRiotApiService basicRiotApiService;

    public String getChampionPortraitImgURLByChampionName(String championName) {
        if (championName == null) {
            return "https://ddragon.leagueoflegends.com/cdn/13.24.1/img/champion/Teemo.png";
        }
        String latestLOLVersion = basicRiotApiService.getLatestLOLVersion();
        String api_url = "https://ddragon.leagueoflegends.com/cdn/" + latestLOLVersion + "/img/champion/" + championName + ".png";
        return api_url;
    }

}
