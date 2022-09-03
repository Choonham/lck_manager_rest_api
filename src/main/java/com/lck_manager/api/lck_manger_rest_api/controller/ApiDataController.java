package com.lck_manager.api.lck_manger_rest_api.controller;

import com.lck_manager.api.lck_manger_rest_api.entity.Player;
import com.lck_manager.api.lck_manger_rest_api.entity.Season;
import com.lck_manager.api.lck_manger_rest_api.entity.Team;
import com.lck_manager.api.lck_manger_rest_api.entity.User;
import com.lck_manager.api.lck_manger_rest_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value ="/regUser", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public int regUser(@RequestBody User user) {
        /*User user = new User();
        user.setUserId(userId);
        user.setUserNickName(userNickName);
        user.setSeasonCode(Integer.parseInt(seasonCode));*/
        return userRepository.save(user).getUserCode();
    }
    // ################### user End ################## //

    // ################### Team Start ################## //
    @RequestMapping(value ="/getTeamList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getTeamList(@RequestBody Map<String, String> params) {
        Season season = seasonRepository.findSeasonBySeasonForShort(params.get("seasonForShort"));
        return teamRepository.findAllBySeason(season);
    }

    @RequestMapping(value ="/getTeamInfo", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getTeamInfo(@RequestBody Map<String, String> params) {
        return teamRepository.findAllByTeamCode(Integer.parseInt(params.get("teamCode")));
    }
    // ################### Team End ################## //


    // ################### Season Start ################## //
    @RequestMapping(value ="/getSeasonList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getSeasonList() {
        return seasonRepository.findAllBy();
    }
    // ################### Season End ################## //


    // ################### Champion Start ################## //
    @RequestMapping(value ="/getChampionList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getChampionList() {
        return championRepository.findAllBy();
    }

    @RequestMapping(value ="/getChampionInfo", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getChampionInfo(@RequestBody Map<String, String> params) {
        return championRepository.findChampionByChampionCode(Integer.parseInt(params.get("championCode")));
    }

    @RequestMapping(value ="/getChampionCounterInfo", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getChampionCounterInfo(@RequestBody Map<String, String> params) {
        int championCode = Integer.parseInt(params.get("championCode"));
        int counterChampionCode = Integer.parseInt(params.get("counterChampionCode"));

        return championCounterRepository.findChampionCounterByChampionAndCounterChampion(championCode, counterChampionCode);
    }

    @RequestMapping(value ="/getChampionCounters", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getChampionCounters(@RequestBody Map<String, String> params) {
        return championCounterRepository.findChampionCountersByChampion(Integer.parseInt(params.get("playerCode")));
    }
    // ################### Champion End ################## //


    // ################### Player Start ################## //
    @RequestMapping(value ="/getPlayerList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getPlayerList() {
        return playerRepository.findAllBy();
    }


    @RequestMapping(value ="/getSeasonPlayerList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getSeasonPlayerList(@RequestBody Map<String, String> params) {
        Season season = seasonRepository.findSeasonBySeasonForShort(params.get("seasonForShort"));
        return playerRepository.findAllBySeasonCode(season);
    }


    @RequestMapping(value ="/getPlayerInfo", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getPlayerInfo(@RequestBody Map<String, String> params) {
        return playerRepository.findAllByPlayerCode(Integer.parseInt(params.get("playerCode")));
    }

    @RequestMapping(value ="/getFirstPlayerList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getFirstPlayerList(@RequestBody Map<String, String> params) {
        List<Player> firstPlayerList = new ArrayList<>();
        for(int i = 1; i <=5; i++) {
            List<Player> tempList = playerRepository.getFirstPlayerList(i,Integer.parseInt(params.get("seasonCode")));
            for(Player player : tempList) {
                firstPlayerList.add(player);
            }
        }
        return firstPlayerList;
    }
    // ################### Player End ################## //


    // ################### Roster Start ################## //
    @RequestMapping(value ="/getTeamRoster", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getTeamRoster(@RequestBody Map<String, String> params) {
        Team team = teamRepository.findAllByTeamCode(Integer.parseInt(params.get("teamCode")));
        return rosterRepository.findAllByTeamAndMainEntry(team, Integer.parseInt(params.get("entryCode")));
    }

    // ################### Roster End ################## //



}
