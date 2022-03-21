package com.lewis.teamget.controller;

import com.lewis.teamget.VO.TeamMainInfo;
import com.lewis.teamget.VO.TeamSimpleInfo;
import com.lewis.teamget.VO.UserPublisher;
import com.lewis.teamget.entity.Team;
import com.lewis.teamget.service.TeamService;
import com.lewis.teamget.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    TeamService teamService;

//    @PostMapping("/test")
//    public void test(@RequestBody Map<String,Object> map){
//        String competitionId=(String) map.get("competitionId");
//
//        String cover=teamService.findCoverByCompetitionId(competitionId);
//        System.out.println(cover);
//    }

    //发布队伍
    @PostMapping("/addTeam")
    public JSONResult addTeam(@RequestBody Map<String,Object> map){
        Team team=new Team();
        String openId=(String) map.get("openId");
        String people=(String) map.get("people");
        String limit=(String) map.get("limit");
        String deadlineStr=(String) map.get("deadline");
        String title=(String) map.get("title");
        String summary=(String) map.get("summary");
        String need=(String) map.get("need");
        String competitionTitle=(String) map.get("competitionTitle");
        if(competitionTitle.equals("")||competitionTitle.length()==0){
            return JSONResult.errorMsg("比赛名称没有填");
        }
        if(openId.equals("")||openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(teamService.findCountByOpenId(openId)==0){
            return JSONResult.errorMsg("用户未注册");
        }
//        if(people.equals("")||people.length()==0){
//            return JSONResult.errorMsg("人数限制不能为空");
//        }
//        if(limit.equals("")||limit.length()==0){
//            return JSONResult.errorMsg("限制不能为空");
//        }
        if(deadlineStr.equals("")||deadlineStr.length()==0){
            return JSONResult.errorMsg("截止日期不能为空");
        }
        if(title.equals("")||title.length()==0){
            return JSONResult.errorMsg("队伍标题不能为空");
        }
//        if(summary.equals("")||summary.length()==0){
//            return JSONResult.errorMsg("简介不能为空");
//        }
//        if(need.equals("")||need.length()==0){
//            return JSONResult.errorMsg("需求不能为空");
//        }
        //team.setDeleted("0");
        team.setOpenId(openId);
        //填充competitionId
        String competitionId=teamService.findCompetitionIdByTitle(competitionTitle);
        if(competitionId==null||competitionId.equals("")||competitionId.length()==0){
            competitionId="0";
            //TODO
            team.setCover("http://qowu3u4sd.hn-bkt.clouddn.com/duiwu.jpg");
        }else {
            String cover = teamService.findCoverByCompetitionId(competitionId);
            team.setCover(cover);
        }
        team.setCompetitionTitle(competitionTitle);
        team.setCompetitionId(competitionId);
        //插入图片

        team.setPeople(people);
        team.setLimits(limit);
        //处理date
        SimpleDateFormat deadlineDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat createDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date deadline= null;
        //创建时间
        Date nowTime=new Date();
        String createTime=createDateFormat.format(nowTime);

        try {
            deadline = deadlineDateFormat.parse(deadlineStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(deadlineDateFormat.format(deadline));
        team.setDeadline(deadline);
        team.setCreateTime(createTime);
        team.setTitle(title);
        team.setSummary(summary);
        team.setNeed(need);
        System.out.println(team);
        teamService.addTeam(team);
        return JSONResult.okMsg("发布成功，正在审核");
    }

    //用于addTeam()
    //“发布比赛”列出所有比赛的名称By首字母
    @PostMapping("/findAllTeamNameList")
    public JSONResult findAllTeamNameList(){
        List<String> resultList=teamService.findAllTeamNameList();
        return JSONResult.okData(resultList);
    }

    //列出所有比赛By最新
    @PostMapping("/findAllTeamNameListByTime")
    public JSONResult findAllTeamNameListByTime(){
        List<TeamSimpleInfo> resultList=teamService.findAllTeamNameListByTime();
        return JSONResult.okData(resultList);
    }

    //列出所有比赛By推荐
    @PostMapping("/findAllTeamNameListByRecommend")
    public JSONResult findAllTeamNameListByRecommend(){
        List<TeamSimpleInfo> resultList=teamService.findAllTeamNameListByRecommend();
        return JSONResult.okData(resultList);
    }

    //通过竞赛找到队伍
    @PostMapping("/findTeamListByCompetition")
    public JSONResult findTeamListByCompetition(@RequestBody Map<String,Object> map){
        String competitionId=(String) map.get("competitionId");
        List<TeamSimpleInfo> resultList=teamService.findTeamListByCompetition(competitionId);
        return JSONResult.okData(resultList);
    }


    //查看队伍详情
    @PostMapping("/findTeamDetails")
    public JSONResult findTeamDetails(@RequestBody Map<String,Object> map){
        String teamId=(String) map.get("teamId");
        System.out.println("teamId:"+teamId);
        String openId=(String) map.get("openId");
        System.out.println("openId:"+openId);
        TeamMainInfo result=teamService.findTeamDetailsByTeamId(teamId);

        if(teamId.equals("")||teamId.length()==0){
            return JSONResult.errorMsg("队伍ID不能为空");
        }
        if(openId.equals("")||openId.length()==0){
            result.setIsCollected("false");
        }else {
            String isCollected=teamService.findIsCollectedByOpenId(openId,teamId);
            result.setIsCollected(isCollected);
        }
        String publisherOpenId=result.getOpenId();

        UserPublisher publisher =teamService.findTeamPublisher(publisherOpenId);
        result.setOpenId(publisher.getOpenId());
        result.setNickName(publisher.getNickName());
        result.setGrade(publisher.getGrade());
        result.setCollege(publisher.getCollege());
        result.setAvatar(publisher.getAvatar());
        result.setContactWay(publisher.getContactWay());
        System.out.println(result);
        return JSONResult.okData(result);
    }

    //收藏队伍
    @PostMapping("/collectTeam")
    public JSONResult collectTeam(@RequestBody Map<String,Object> map){
        String openId=(String)map.get("openId");
        String teamId=(String)map.get("teamId");

        if(openId.equals("")||openId.length()==0){
            return JSONResult.errorMsg("用户Id不能为空");
        }
        if(teamId.equals("")||teamId.length()==0){
            return JSONResult.errorMsg("队伍Id不能为空");
        }
        teamService.collectTeam(openId,teamId);
        return JSONResult.ok();
    }
}
