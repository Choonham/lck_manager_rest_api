package com.lck_manager.api.lck_manger_rest_api.controller;

import com.lck_manager.api.lck_manger_rest_api.entity.Season;
import com.lck_manager.api.lck_manger_rest_api.entity.Team;
import com.lck_manager.api.lck_manger_rest_api.entity.User;
import com.lck_manager.api.lck_manger_rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiDataServer")
public class ApiDataController {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    SeasonRepository seasonRepository;

    @Autowired
    ChampionRepository championRepository;

    @Autowired
    ChampionCounterRepository championCounterRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RosterRepository rosterRepository;

    @Autowired
    UserRepository userRepository;

    // ################### User Start ################## //
    @GetMapping("/regUser")
    @ResponseBody
    public int regUser(@RequestParam User user) {
        return userRepository.save(user).getUserCode();
    }
    // ################### user End ################## //

    // ################### Team Start ################## //
    @GetMapping("/getTeamList")
    @ResponseBody
    public Object getTeamList(@RequestParam String seasonForShort) {
        Season season = seasonRepository.findSeasonBySeasonForShort(seasonForShort);
        return teamRepository.findAllBySeason(season);
    }

    @GetMapping("/getTeamInfo")
    @ResponseBody
    public Object getTeamInfo(@RequestParam int teamCode) {
        return teamRepository.findAllByTeamCode(teamCode);
    }
    // ################### Team End ################## //


    // ################### Season Start ################## //
    @GetMapping("/getSeasonList")
    @ResponseBody
    public Object getSeasonList() {
        return seasonRepository.findAllBy();
    }
    // ################### Season End ################## //


    // ################### Champion Start ################## //
    @GetMapping("/getChampionList")
    @ResponseBody
    public Object getChampionList() {
        return championRepository.findAllBy();
    }

    @GetMapping("/getChampionInfo")
    @ResponseBody
    public Object getChampionInfo(@RequestParam int championCode) {
        return championRepository.findChampionByChampionCode(championCode);
    }

    @GetMapping("/getChampionCounterInfo")
    @ResponseBody
    public Object getChampionCounterInfo(@RequestParam int championCode, @RequestParam int counterChampionCode) {
        return championCounterRepository.findChampionCounterByChampionAndCounterChampion(championCode, counterChampionCode);
    }

    @GetMapping("/getChampionCounters")
    @ResponseBody
    public Object getChampionCounters(@RequestParam int championCode) {
        return championCounterRepository.findChampionCountersByChampion(championCode);
    }
    // ################### Champion End ################## //


    // ################### Player Start ################## //
    @GetMapping("/getPlayerList")
    @ResponseBody
    public Object getPlayerList() {
        return playerRepository.findAllBy();
    }

    @GetMapping("/getSeasonPlayerList")
    @ResponseBody
    public Object getSeasonPlayerList(String seasonForShort) {
        Season season = seasonRepository.findSeasonBySeasonForShort(seasonForShort);
        return playerRepository.findAllBySeasonCode(season);
    }

    @GetMapping("/getPlayerInfo")
    @ResponseBody
    public Object getPlayerInfo(int playerCode) {
        return playerRepository.findAllByPlayerCode(playerCode);
    }
    // ################### Player End ################## //


    // ################### Roster Start ################## //
    @GetMapping("/getTeamRoster")
    @ResponseBody
    public Object getTeamRoster(int teamCode, int entryCode) {
        Team team = teamRepository.findAllByTeamCode(teamCode);
        return rosterRepository.findAllByTeamAndMainEntry(team, entryCode);
    }
    // ################### Roster End ################## //



}
