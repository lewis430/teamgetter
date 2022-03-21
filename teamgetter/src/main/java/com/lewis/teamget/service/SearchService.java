package com.lewis.teamget.service;

import com.lewis.teamget.VO.CompetitionSimpleInfo;
import com.lewis.teamget.VO.TeamSimpleInfo;
import com.lewis.teamget.mapper.CompetitionMapper;
import com.lewis.teamget.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    CompetitionMapper competitionMapper;

    @Autowired
    TeamMapper teamMapper;



    //////////////////////////////////////////////////////////////////////
    public List<CompetitionSimpleInfo> searchCompetitionByTitleOrderByTime(String title) {
        return competitionMapper.searchCompetitionByTitleOrderByTime(title);
    }


    public List<CompetitionSimpleInfo> searchCompetitionByTitleOrderByRecommend(String title) {
        return competitionMapper.searchCompetitionByTitleOrderByRecommend(title);

    }
    //////////////////////////////////////////////////////////////////////

    public List<TeamSimpleInfo> searchTeamByTitleOrderByRecommend(String title) {
        return teamMapper.searchTeamByTitleOrderByRecommend(title);
    }

    public List<TeamSimpleInfo> searchTeamByTitleOrderByTime(String title) {
        return teamMapper.searchTeamByTitleOrderByTime(title);
    }

    //////////////////////////////////////////////////////////////////////
    public List<CompetitionSimpleInfo> searchCompetitionByNullCatalogAndNullLevelOrderByRecommend() {
        return competitionMapper.findCompetitionListByRecommend();
    }

    public List<CompetitionSimpleInfo> searchCompetitionByLevelOrderByRecommend(String level) {
        return competitionMapper.searchCompetitionByLevelOrderByRecommend(level);
    }

    public List<CompetitionSimpleInfo> searchCompetitionByCatalogAndLevelOrderByRecommend(String catalogId, String level) {
        return competitionMapper.searchCompetitionByCatalogAndLevelOrderByRecommend(catalogId,level);
    }

    public List<CompetitionSimpleInfo> searchCompetitionByCatalogOrderByRecommend(String catalogId) {
        return competitionMapper.searchCompetitionByCatalogOrderByRecommend(catalogId);
    }

    public List<CompetitionSimpleInfo> searchCompetitionByNullCatalogAndNullLevelOrderByTime() {
        return competitionMapper.findCompetitionListByTime();
    }

    public List<CompetitionSimpleInfo> searchCompetitionByLevelOrderByTime(String level) {
        return competitionMapper.searchCompetitionByLevelOrderByTime(level);
    }

    public List<CompetitionSimpleInfo> searchCompetitionByCatalogAndLevelOrderByTime(String catalogId, String level) {
        return competitionMapper.searchCompetitionByCatalogAndLevelOrderByTime(catalogId,level);
    }

    public List<CompetitionSimpleInfo> searchCompetitionByCatalogOrderByTime(String catalogId) {
        return competitionMapper.searchCompetitionByCatalogOrderByTime(catalogId);
    }

}
