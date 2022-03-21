package com.lewis.teamget.mapper;

import com.lewis.teamget.VO.CompetitionSimpleInfo;
import com.lewis.teamget.VO.TeamMainInfo;
import com.lewis.teamget.VO.TeamSimpleInfo;
import com.lewis.teamget.VO.UserPublisher;
import com.lewis.teamget.entity.Team;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeamMapper {
    //添加队伍
    void addTeam(Team team);
    //查询比赛下的所有队伍
    List<TeamSimpleInfo> findTeamListByCompetition(String competitionId);
    //查询所有比赛列表
    List<String> findAllTeamNameList();
    //通过标题查找比赛
    String findCompetitionIdByTitle(String competitionTitle);
    //通过比赛ID查找比赛封面
    String findCoverByCompetitionId(String competitionId);
    //查询所有比赛名称列表，并按照时间排序
    List<TeamSimpleInfo> findAllTeamNameListByTime();
    //询所有比赛名称列表，并按照推荐排序
    List<TeamSimpleInfo> findAllTeamNameListByRecommend();
    //通过标题搜索队伍，并按照推荐排序
    List<TeamSimpleInfo> searchTeamByTitleOrderByRecommend(String title);
    //通过队伍ID，查询队伍细节
    TeamMainInfo findTeamDetailsByTeamId(String teamId);
    //查询队伍的发布者
    UserPublisher findTeamPublisher(String openId);
    //收藏队伍
    void collectTeam(String openId, String teamId);
    //通过用户ID和队伍判断该用户是否收藏该比赛
    int findIsCollectedByOpenId(String openId, String teamId);
    //通过标题搜索队伍，并按照时间排序
    List<TeamSimpleInfo> searchTeamByTitleOrderByTime(String title);
    //通过用户ID查询数量
    int findCountByOpenId(String openId);
}
