package com.lewis.teamget.mapper;

import com.lewis.teamget.VO.CompetitionMainInfo;
import com.lewis.teamget.VO.CompetitionSimpleInfo;
import com.lewis.teamget.entity.Competition;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CompetitionMapper {
    //添加比赛
    void addCompetition(Competition competition);
    //通过时间查找比赛
    List<CompetitionSimpleInfo> findCompetitionListByTime();
    //通过推荐查找比赛
    List<CompetitionSimpleInfo> findCompetitionListByRecommend();
    //通过标题搜索比赛，并且按照时间排序
    List<CompetitionSimpleInfo> searchCompetitionByTitleOrderByTime(String title);
    //通过分类搜索比赛，并按照推荐排序
    List<CompetitionSimpleInfo> searchCompetitionByCatalogOrderByRecommend(String catalog);
    //通过级别搜索比赛，并按照推荐排序
    List<CompetitionSimpleInfo> searchCompetitionByLevelOrderByRecommend(String level);
    //通过分类搜索比赛，并按照推荐排序
    List<CompetitionSimpleInfo> searchCompetitionByCatalogAndLevelOrderByRecommend(String catalogId, String level);
    //通过比赛ID查询比赛详情
    CompetitionMainInfo findCompetitionDetailsByCompetitionId(String competitionId);
    //通过比赛ID查询该比赛的分类
    String findCatalogByCompetitionId(String competitionId);
    //收藏比赛
    void collectCompetition(String openId, String competitionId);
    //通过比赛ID查询该比赛的报名时间
    String findSignUpTimeByCompetitionId(String competitionId);
    //通过比赛ID查询该比赛的参赛时间
    String findParticipateTimeByCompetitionId(String competitionId);
    //通过用户ID和比赛查询该用户是否收藏该比赛
    int findIsCollectedByOpenId(String openId, String competitionId);
    //通过标题搜素比赛，并按照推荐排序
    List<CompetitionSimpleInfo> searchCompetitionByTitleOrderByRecommend(String title);
    //通过级别搜索比赛，并按照时间排序
    List<CompetitionSimpleInfo> searchCompetitionByLevelOrderByTime(String level);
    //通过分类或级别搜索比赛，并按照时间排序
    List<CompetitionSimpleInfo> searchCompetitionByCatalogAndLevelOrderByTime(String catalogId, String level);
    //通过分类搜索比赛，并按照时间排序
    List<CompetitionSimpleInfo> searchCompetitionByCatalogOrderByTime(String catalogId);
    //查找所有边栏URL
    List<String> findBannerUrlList();
}
