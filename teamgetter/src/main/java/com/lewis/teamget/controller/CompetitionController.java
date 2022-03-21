package com.lewis.teamget.controller;

import com.lewis.teamget.VO.*;
import com.lewis.teamget.entity.Competition;
import com.lewis.teamget.service.CompetitionService;
import com.lewis.teamget.utils.JSONResult;
import com.lewis.teamget.utils.QiniuUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @PostMapping("/findCompetitionListByTime")
    public JSONResult findCompetitionListByTime(@RequestBody Map<String, Object> map){
        //String competitionId=(String) map.get("competitionId");
        List<CompetitionSimpleInfo> resultList =  competitionService.findCompetitionListByTime();
        System.out.println(resultList);
        return JSONResult.okData(resultList);
    }

    @PostMapping("/findCompetitionListByRecommend")
    public JSONResult findCompetitionListByRecommend(){
        List<CompetitionSimpleInfo> resultList =  competitionService.findCompetitionListByRecommend();
        System.out.println(resultList);
        return JSONResult.okData(resultList);
    }

    //查看比赛详情
    @PostMapping("/findCompetitionDetails")
    public JSONResult findCompetitionDetails(@RequestBody Map<String,Object> map){
        String competitionId=(String) map.get("competitionId");
        String openId=(String) map.get("openId");
        CompetitionMainInfo result=competitionService.findCompetitionDetailsByCompetitionId(competitionId);
        if(competitionId.equals("")||competitionId.length()==0){
            return JSONResult.errorMsg("比赛Id不能为空");
        }
        if(openId.equals("")||openId.length()==0){
            result.setIsCollected("false");
        }else {
            String isCollected=competitionService.findIsCollectedByOpenId(openId,competitionId);
            result.setIsCollected(isCollected);
        }
        String catalog=competitionService.findCatalogByCompetitionId(competitionId);
        result.setCatalog(catalog);
        return JSONResult.okData(result);
    }

    //收藏比赛
    @RequestMapping("/collectCompetition")
    public JSONResult collectCompetition(@RequestBody Map<String,Object> map){
        String openId=(String) map.get("openId");
        String competitionId=(String) map.get("competitionId");
        if(openId.equals("")||openId.length()==0){
            return JSONResult.errorMsg("用户Id不能为空");
        }
        if(competitionId.equals("")||competitionId.length()==0){
            return JSONResult.errorMsg("比赛Id不能为空");
        }
        competitionService.collectCompetition(openId,competitionId);
        return JSONResult.ok();
    }

    @RequestMapping("/getBanner")
    public JSONResult collectCompetition(){
        List<String> result=competitionService.findBannerUrlList();
        //result.add("http://qk2p8qc9y.hn-bkt.clouddn.com/banner.jpg");
        return JSONResult.okData(result);
    }

}
