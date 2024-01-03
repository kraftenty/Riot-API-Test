package com.kraftenty.lol.service;

import com.kraftenty.lol.dto.ChampionDataDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@AllArgsConstructor
public class ChampionDataService {
    private final BasicRiotApiService basicRiotApiService;

    public ChampionDataDTO.ChampionDTO getChampionInfoByChampionId(String receivedChampionKey) {
        if (receivedChampionKey == null) {
            receivedChampionKey = "266";
        }

        String latestLOLVersion = basicRiotApiService.getLatestLOLVersion();

        String api_url = "https://ddragon.leagueoflegends.com/cdn/" + latestLOLVersion + "/data/ko_KR/champion.json";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ChampionDataDTO> response = restTemplate.exchange(
                api_url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<ChampionDataDTO>() {}
        );

        ChampionDataDTO championDataDTO = response.getBody();
        Map<String, ChampionDataDTO.ChampionDTO> championMappingMap = championDataDTO.getData();
        for (ChampionDataDTO.ChampionDTO value : championMappingMap.values()) {
            if(value.getKey().equals(receivedChampionKey))
                return value;
        }

        return null;
    }
}
