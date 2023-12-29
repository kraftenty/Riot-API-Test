package com.kraftenty.lol.service;

import com.kraftenty.lol.dto.ChampionDataDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChampionDataService {
    private final BasicRiotApiService basicRiotApiService;

    public ChampionDataDTO.ChampionDTO getChampionInfoByChampionId(String receivedChampionKey) {

    }

}
