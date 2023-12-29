package com.kraftenty.lol.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BasicRiotApiService {

    public String getLatestLOLVersion() {
        String api_url = "https://ddragon.leagueoflegends.com/api/versions.json";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange(
                api_url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<String>>() {}
        );
        List<String> versions = response.getBody();
        String latestVersion = versions.get(0);
        return latestVersion;
    }

}
