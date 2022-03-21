package com.lewis.teamget.service;

import com.lewis.teamget.VO.TeamMainInfo;
import com.lewis.teamget.VO.TeamSimpleInfo;
import com.lewis.teamget.VO.UserPublisher;
import com.lewis.teamget.entity.Team;
import com.lewis.teamget.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TeamService {
    @Autowired
    TeamMapper teamMapper;

    public void addTeam(Team team) {
        teamMapper.addTeam(team);
    }

    public List<TeamSimpleInfo> findTeamListByCompetition(String competitionId) {
        return teamMapper.findTeamListByCompetition(competitionId);
    }

    public List<String> findAllTeamNameList() {
        return teamMapper.findAllTeamNameList();
    }

    public String findCompetitionIdByTitle(String competitionTitle) {
        return teamMapper.findCompetitionIdByTitle(competitionTitle);
    }

    public String findCoverByCompetitionId(String competitionId) {
        return teamMapper.findCoverByCompetitionId(competitionId);
    }

    public List<TeamSimpleInfo> findAllTeamNameListByTime() {
        return teamMapper.findAllTeamNameListByTime();
    }

    public List<TeamSimpleInfo> findAllTeamNameListByRecommend() {
        return teamMapper.findAllTeamNameListByRecommend();
    }


    public TeamMainInfo findTeamDetailsByTeamId(String teamId) {
        return teamMapper.findTeamDetailsByTeamId(teamId);
    }

    public UserPublisher findTeamPublisher(String openId) {
        return teamMapper.findTeamPublisher(openId);
    }

    public void collectTeam(String openId, String teamId) {
        teamMapper.collectTeam(openId,teamId);
    }

    public String findIsCollectedByOpenId(String openId, String teamId) {
        int result= teamMapper.findIsCollectedByOpenId(openId,teamId);
        if(result==0){
            return "false";
        }else {
            return "true";
        }
    }

    public int findCountByOpenId(String openId) {
        return teamMapper.findCountByOpenId(openId);
    }
}
