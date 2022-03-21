package com.lewis.teamget.controller;


import com.lewis.teamget.VO.CompetitionSimpleInfo;
import com.lewis.teamget.VO.TeamSimpleInfo;
import com.lewis.teamget.service.CompetitionService;
import com.lewis.teamget.service.SearchService;
import com.lewis.teamget.service.TeamService;
import com.lewis.teamget.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    SearchService searchService;

    @Autowired
    TeamService teamService;

    @Autowired
    CompetitionService competitionService;

    //10-20

    @PostMapping("/searchCompetitionByTitle")
    public JSONResult searchCompetitionByTitle(@RequestBody Map<String,Object> map){
//        String title=(String) map.get("title");
//        System.out.println(title);@RequestBody Map<String,Object> map
        String title=(String) map.get("title");
        if(title==null||title.equals("")||title.length()==0){
            List<CompetitionSimpleInfo> resultList =  competitionService.findCompetitionListByTime();
            return JSONResult.okData(resultList);
        }
        System.out.println(title);
        List<CompetitionSimpleInfo> resultList=searchService.searchCompetitionByTitleOrderByTime(title);
        return JSONResult.okData(resultList);
    }

    //搜索竞赛：通过时间
    @PostMapping("/searchCompetitionByTitleOrderByTime")
    public JSONResult searchCompetitionByTitleOrderByTime(@RequestBody Map<String,Object> map){
//        String title=(String) map.get("title");
//        System.out.println(title);@RequestBody Map<String,Object> map
        String title=(String) map.get("title");
        if(title==null||title.equals("")||title.length()==0){
            List<CompetitionSimpleInfo> resultList =  competitionService.findCompetitionListByTime();
            return JSONResult.okData(resultList);
        }
        System.out.println(title);
        List<CompetitionSimpleInfo> resultList=searchService.searchCompetitionByTitleOrderByTime(title);
        return JSONResult.okData(resultList);
    }

    //搜索竞赛：通过推荐值
    @PostMapping("/searchCompetitionByTitleOrderByRecommend")
    public JSONResult searchCompetitionByTitleOrderByRecommend(@RequestBody Map<String,Object> map){
//        String title=(String) map.get("title");
//        System.out.println(title);@RequestBody Map<String,Object> map
        String title=(String) map.get("title");
        if(title==null||title.equals("")||title.length()==0){
            List<CompetitionSimpleInfo> resultList =  competitionService.findCompetitionListByRecommend();
            return JSONResult.okData(resultList);
        }
        System.out.println(title);
        List<CompetitionSimpleInfo> resultList=searchService.searchCompetitionByTitleOrderByRecommend(title);
        return JSONResult.okData(resultList);
    }

    ////////////////////////////////////////////////////////////////////////////

    //搜索队伍：通过推荐值
    @PostMapping("/searchTeamByTitleOrderByRecommend")
    public JSONResult searchTeamByTitleOrderByRecommend(@RequestBody Map<String,Object> map){
//        String title=(String) map.get("title");
//        System.out.println(title);@RequestBody Map<String,Object> map
        String title=(String) map.get("title");
        if(title==null||title.equals("")||title.length()==0){
            List<TeamSimpleInfo> resultList=teamService.findAllTeamNameListByRecommend();
            return JSONResult.okData(resultList);
        }
        System.out.println(title);
        List<TeamSimpleInfo> resultList=searchService.searchTeamByTitleOrderByRecommend(title);
        return JSONResult.okData(resultList);
    }


    @PostMapping("/searchTeamByTitle")
    public JSONResult searchTeamByTitle(@RequestBody Map<String,Object> map){
//        String title=(String) map.get("title");
//        System.out.println(title);@RequestBody Map<String,Object> map
        String title=(String) map.get("title");
        if(title==null||title.equals("")||title.length()==0){
            List<TeamSimpleInfo> resultList=teamService.findAllTeamNameListByTime();
            return JSONResult.okData(resultList);
        }
        System.out.println(title);
        List<TeamSimpleInfo> resultList=searchService.searchTeamByTitleOrderByTime(title);
        return JSONResult.okData(resultList);
    }

    //搜索队伍：通过推荐值
    @PostMapping("/searchTeamByTitleOrderByTime")
    public JSONResult searchTeamByTitleOrderByTime(@RequestBody Map<String,Object> map){
//        String title=(String) map.get("title");
//        System.out.println(title);@RequestBody Map<String,Object> map
        String title=(String) map.get("title");
        if(title==null||title.equals("")||title.length()==0){
            List<TeamSimpleInfo> resultList=teamService.findAllTeamNameListByTime();
            return JSONResult.okData(resultList);
        }
        System.out.println(title);
        List<TeamSimpleInfo> resultList=searchService.searchTeamByTitleOrderByTime(title);
        return JSONResult.okData(resultList);
    }


    ////////////////////////////////////////////////////////////////////////////

    //通过“类别”搜索比赛：通过推荐值
    @PostMapping("/searchCompetitionListByCatalogOrLevel")
    public JSONResult searchCompetitionListByCatalogOrLevel(@RequestBody Map<String,Object> map){

        String catalogId=(String) map.get("catalogId");
        boolean flagCatalogId;
        if (catalogId==null||catalogId.equals("")||catalogId.length()==0){
            flagCatalogId=false;
        }else {
            flagCatalogId=true;
        }
        String level=(String) map.get("level");
        boolean flagLevel;
        if (level==null||level.equals("")||level.length()==0){
            flagLevel=false;
        }else {
            flagLevel=true;
        }
        List<CompetitionSimpleInfo> resultList;
        if(flagCatalogId==false && flagLevel==false){
            resultList=searchService.searchCompetitionByNullCatalogAndNullLevelOrderByRecommend();
        }else if(flagCatalogId && flagLevel==false){
            resultList=searchService.searchCompetitionByCatalogOrderByRecommend(catalogId);
        }else if(flagCatalogId==false && flagLevel){
            resultList=searchService.searchCompetitionByLevelOrderByRecommend(level);
        }else{
            resultList=searchService.searchCompetitionByCatalogAndLevelOrderByRecommend(catalogId,level);
        }

        return JSONResult.okData(resultList);
    }

    //通过“类别”搜索比赛：通过推荐值
    @PostMapping("/searchCompetitionListByCatalogOrLevelOrderByRecommend")
    public JSONResult searchCompetitionListByCatalogOrLevelOrderByRecommend(@RequestBody Map<String,Object> map){

        String catalogId=(String) map.get("catalogId");
        boolean flagCatalogId;
        if (catalogId==null||catalogId.equals("")||catalogId.length()==0){
            flagCatalogId=false;
        }else {
            flagCatalogId=true;
        }
        String level=(String) map.get("level");
        boolean flagLevel;
        if (level==null||level.equals("")||level.length()==0){
            flagLevel=false;
        }else {
            flagLevel=true;
        }
        List<CompetitionSimpleInfo> resultList;
        if(flagCatalogId==false && flagLevel==false){
            resultList=searchService.searchCompetitionByNullCatalogAndNullLevelOrderByRecommend();
        }else if(flagCatalogId && flagLevel==false){
            resultList=searchService.searchCompetitionByCatalogOrderByRecommend(catalogId);
        }else if(flagCatalogId==false && flagLevel){
            resultList=searchService.searchCompetitionByLevelOrderByRecommend(level);
        }else{
            resultList=searchService.searchCompetitionByCatalogAndLevelOrderByRecommend(catalogId,level);
        }

        return JSONResult.okData(resultList);
    }

    //通过“类别”搜索比赛：通过时间
    @PostMapping("/searchCompetitionListByCatalogOrLevelOrderByTime")
    public JSONResult searchCompetitionListByCatalogOrLevelOrderByTime(@RequestBody Map<String,Object> map){

        String catalogId=(String) map.get("catalogId");
        boolean flagCatalogId;
        if (catalogId==null||catalogId.equals("")||catalogId.length()==0){
            flagCatalogId=false;
        }else {
            flagCatalogId=true;
        }
        String level=(String) map.get("level");
        boolean flagLevel;
        if (level==null||level.equals("")||level.length()==0){
            flagLevel=false;
        }else {
            flagLevel=true;
        }
        List<CompetitionSimpleInfo> resultList;
        if(flagCatalogId==false && flagLevel==false){
            resultList=searchService.searchCompetitionByNullCatalogAndNullLevelOrderByTime();
        }else if(flagCatalogId && flagLevel==false){
            resultList=searchService.searchCompetitionByCatalogOrderByTime(catalogId);
        }else if(flagCatalogId==false && flagLevel){
            resultList=searchService.searchCompetitionByLevelOrderByTime(level);
        }else{
            resultList=searchService.searchCompetitionByCatalogAndLevelOrderByTime(catalogId,level);
        }

        return JSONResult.okData(resultList);
    }
}
