package com.lck_manager.api.lck_manger_rest_api.controller;

import com.lck_manager.api.lck_manger_rest_api.entity.*;
import com.lck_manager.api.lck_manger_rest_api.repository.*;
import com.lck_manager.api.lck_manger_rest_api.service.AuthService;
import com.querydsl.jpa.impl.JPAQuery;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    @Autowired
    AuthService authService;

    // ################### User Start ################## //
    @RequestMapping(value ="/regUser", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object regUser(@RequestBody User user, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("userCode", Integer.toString(userRepository.save(user).getUserCode()));
        hashMap.put("success", "true");

        return new JSONObject(hashMap);
    }
    // ################### user End ################## //

    // ################### Team Start ################## //
    @RequestMapping(value ="/getTeamList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getTeamList(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        Season season = seasonRepository.findSeasonBySeasonCode(Integer.parseInt(params.get("seasonCode")));
        User adminUser = userRepository.findUserByUserCode(0);
        User user = userRepository.findUserByUserCode(Integer.parseInt(params.get("userCode")));
        return teamRepository.findAllBySeasonAndAdminOrUserCode(season, adminUser, user);
    }

    @RequestMapping(value ="/getTeamInfo", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getTeamInfo(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        return teamRepository.findAllByTeamCode(Integer.parseInt(params.get("teamCode")));
    }

    @RequestMapping(value ="/regTeam", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object regTeam(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";

        int userCode = Integer.parseInt(params.get("userCode"));
        String teamName = params.get("teamName");
        int seasonCode = Integer.parseInt(params.get("seasonCode"));

        User user = null;
        Season season = null;

        HashMap<String, String> hashMap = new HashMap<>();

        int rtnVal = 0;

        try {
            user =  userRepository.findUserByUserCode(userCode);
            season = seasonRepository.findSeasonBySeasonCode(seasonCode);

            if(user != null) {
                Team team = new Team();
                team.setTeamName(teamName);
                team.setUserCode(user);
                team.setSeason(season);

                rtnVal = teamRepository.save(team).getTeamCode();

                hashMap.put("teamCode", Integer.toString(rtnVal));
                hashMap.put("success", "true");
            }
        } catch (Exception e) {
            e.getStackTrace();
            hashMap.put("success", "false");
        }

        return new JSONObject(hashMap);
    }


    // ################### Team End ################## //


    // ################### Season Start ################## //
    @RequestMapping(value ="/getSeasonList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getSeasonList(@RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        return seasonRepository.findAllBy();
    }
    // ################### Season End ################## //


    // ################### Champion Start ################## //
    @RequestMapping(value ="/getChampionList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getChampionList(@RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        return championRepository.findAllBy();
    }

    @RequestMapping(value ="/getChampionInfo", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getChampionInfo(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        return championRepository.findChampionByChampionCode(Integer.parseInt(params.get("championCode")));
    }

    @RequestMapping(value ="/getChampionCounterInfo", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getChampionCounterInfo(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";

        int championCode = Integer.parseInt(params.get("championCode"));
        int counterChampionCode = Integer.parseInt(params.get("counterChampionCode"));

        return championCounterRepository.findChampionCounterByChampionAndCounterChampion(championCode, counterChampionCode);
    }

    @RequestMapping(value ="/getChampionCounters", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getChampionCounters(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";

        return championCounterRepository.findChampionCountersByChampion(Integer.parseInt(params.get("playerCode")));
    }
    // ################### Champion End ################## //


    // ################### Player Start ################## //
    @RequestMapping(value ="/getPlayerList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getPlayerList(@RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        return playerRepository.findAllBy();
    }


    @RequestMapping(value ="/getSeasonPlayerList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getSeasonPlayerList(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        Season season = seasonRepository.findSeasonBySeasonCode(Integer.parseInt(params.get("seasonCode")));
        return playerRepository.findAllBySeasonCode(season);
    }


    @RequestMapping(value ="/getPlayerInfo", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getPlayerInfo(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        return playerRepository.findAllByPlayerCode(Integer.parseInt(params.get("playerCode")));
    }

    @RequestMapping(value ="/getFirstPlayerList", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getFirstPlayerList(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        List<Player> firstPlayerList = new ArrayList<>();
        for(int i = 0; i <5; i++) {
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
    public Object getTeamRoster(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";
        Team team = teamRepository.findAllByTeamCode(Integer.parseInt(params.get("teamCode")));
        return rosterRepository.findAllByTeamAndMainEntry(team, Integer.parseInt(params.get("entryCode")));
    }

    @RequestMapping(value ="/getTeamRosterBySeasonCode", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object getTeamRosterBySeasonCode(@RequestBody Map<String, String> params, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";

        int seasonCode = Integer.parseInt(params.get("seasonCode"));

        List<Roster> rosterList = rosterRepository.findRosterByTeamSeasonCode(seasonCode);

        return rosterList;
    }

    @RequestMapping(value ="/regFirstRoster", produces="application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object regFirstRoster(@RequestBody List<Map<String, String>> paramList, @RequestParam("key") String key) {
        if(!authService.checkAuth(key)) return "incorrect api key";

        HashMap<String, String> hashMap = new HashMap<>();

        List<Roster> inputRoster = new ArrayList<>();

        try {
            for(Map<String, String> param : paramList) {
                Player player = playerRepository.findAllByPlayerCode(Integer.parseInt(param.get("playerCode")));
                Team team = teamRepository.findAllByTeamCode(Integer.parseInt(param.get("teamCode")));

                Roster roster = new Roster();

                roster.setPlayer(player);
                roster.setTeam(team);

                inputRoster.add(rosterRepository.save(roster));
            }
            hashMap.put("success", "true");

            return inputRoster;

        } catch (Exception e) {
            e.getStackTrace();

            hashMap.put("success", "false");

            return new JSONObject(hashMap);
        }
    }

    // ################### Roster End ################## //



}
