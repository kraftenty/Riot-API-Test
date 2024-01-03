package com.kraftenty.lol.controller;

import com.fasterxml.jackson.databind.deser.BasicDeserializerFactory;
import com.kraftenty.lol.dto.AccountDTO;
import com.kraftenty.lol.dto.ChampionDataDTO;
import com.kraftenty.lol.dto.ChampionMasteryDTO;
import com.kraftenty.lol.dto.SummonerDTO;
import com.kraftenty.lol.service.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpResponse;
import java.util.List;

@Controller
@AllArgsConstructor
public class SearchController {

    private final AccountService accountService;
    private final SummonerService summonerService;
    private final ChampionMasteryService championMasteryService;
    private final ChampionDataService championDataService;
    private final ChampionImgService championImgService;

    @GetMapping("/search")
    public String search(@RequestParam String gameName, @RequestParam String tagLine, Model model) {

        // 1번. gameName과 tagLine으로 PUUID를 받아온다.
        AccountDTO accontDTO = accountService.getAccountInformation(gameName, tagLine);
        System.out.println("accontDTO = " + accontDTO);


        // 2번. PUUID를 가지고 소환사 정보를 받아온다.
        SummonerDTO summonerDTO = summonerService.getSummonerInformationByPUUID(accontDTO.getPuuid());
        System.out.println("summonerDTO = " + summonerDTO);
        model.addAttribute("summonerDTO", summonerDTO);
        model.addAttribute("profileIconURL", summonerService.getSummonerProfileIcon(summonerDTO.getProfileIconId()));


        // 3번. PUUID를 가지고 숙련도 정보를 받아온다.
        List<ChampionMasteryDTO> championMasteryDTOList = championMasteryService.getChampionMasteryInformationsByPUUID(accontDTO.getPuuid(), 5);
        for (ChampionMasteryDTO championMasteryDTOEach : championMasteryDTOList) {
            ChampionDataDTO.ChampionDTO championDTO = championDataService.getChampionInfoByChampionId(Long.toString(championMasteryDTOEach.getChampionId()));
            championMasteryDTOEach.setChampionName(championDTO.getName());
            // 이미지 가져오는 서비스 만들고, 그 서비스로 하여금 championMasteryDTOEach에다가 url을 넣어줘야한다.
            championMasteryDTOEach.setChampionPortraitImgURL(championImgService.getChampionPortraitImgURLByChampionName(championDTO.getId()));
        }
        model.addAttribute("championMasteryDTOList", championMasteryDTOList);

        return "search";
    }
}





