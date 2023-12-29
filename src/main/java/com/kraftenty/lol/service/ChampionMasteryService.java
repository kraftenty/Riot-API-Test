package com.kraftenty.lol.service;

import com.kraftenty.lol.dto.ChampionMasteryDTO;
import com.kraftenty.lol.dto.SummonerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChampionMasteryService {

    @Value("${riot.api.key}")
    private String API_KEY;

    public List<ChampionMasteryDTO> getChampionMasteryInformationsByPUUID(String PUUID, Integer count) {
        if (count == null) {
            count = 3;
        }
        String api_url = "https://kr.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/" + PUUID + "/top?count=" + Integer.toString(count);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", API_KEY);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<ChampionMasteryDTO>> response = restTemplate.exchange(
                api_url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<List<ChampionMasteryDTO>>() {}
        );
        List<ChampionMasteryDTO> championMasteryDTOList = response.getBody();
        return championMasteryDTOList;

    }
}
