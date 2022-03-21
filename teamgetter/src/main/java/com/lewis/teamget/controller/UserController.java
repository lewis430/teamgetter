package com.lewis.teamget.controller;

import com.lewis.teamget.VO.*;
import com.lewis.teamget.entity.User;
import com.lewis.teamget.service.UserService;
import com.lewis.teamget.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /////////////////////////update开始/////////////////////////////
    //OK更新技能
    @PostMapping("/updateSkills")
    public JSONResult updateSkills(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String skills=(String) map.get("skills");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(skills==null || skills.length()==0){
            return JSONResult.errorMsg("skills不能为空");
        }
        userService.updateSkills(openId,skills);
        return JSONResult.okMsg("修改专业成功");
    }

    //OK更新专业
    @PostMapping("/updateMajor")
    public JSONResult updateMajor(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String major=(String) map.get("major");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(major==null || major.length()==0){
            return JSONResult.errorMsg("major不能为空");
        }
        userService.updateMajor(openId,major);
        return JSONResult.okMsg("修改专业成功");
    }

    //OK更新获奖记录
    @PostMapping("/updateAwardExperience")
    public JSONResult updateAwardExperience(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String awardExperience=(String) map.get("awardExperience");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(awardExperience==null || awardExperience.length()==0){
            return JSONResult.errorMsg("awardExperience不能为空");
        }
        userService.updateAwardExperience(openId,awardExperience);
        return JSONResult.okMsg("修改获奖经历成功");
    }

    //OK更新联系方式
    @PostMapping("/updateContactWay")
    public JSONResult updateContactWay(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String contactWay=(String) map.get("contactWay");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(contactWay==null || contactWay.length()==0){
            return JSONResult.errorMsg("contactWay不能为空");
        }
        userService.updateContactWay(openId,contactWay);
        return JSONResult.okMsg("修改联系方式成功");
    }

    //OK更新年级
    @PostMapping("/updateGrade")
    public JSONResult updateGrade(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String grade=(String) map.get("grade");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(grade==null || grade.length()==0){
            return JSONResult.errorMsg("grade不能为空");
        }
        userService.updateGrade(openId,grade);
        return JSONResult.okMsg("修改年级成功");
    }

    //OK更新学院
    @PostMapping("/updateCollege")
    public JSONResult updateCollege(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String college=(String) map.get("college");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(college==null || college.length()==0){
            return JSONResult.errorMsg("college不能为空");
        }
        userService.updateCollege(openId,college);
        return JSONResult.okMsg("修改学院成功");
    }

    //OK更新学校
    @PostMapping("/updateSchool")
    public JSONResult updateSchool(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String school=(String) map.get("school");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(school==null || school.length()==0){
            return JSONResult.errorMsg("school不能为空");
        }
        userService.updateSchool(openId,school);
        return JSONResult.okMsg("修改学校成功");
    }

    //OK更新自我介绍
    @PostMapping("/updateIntroduce")
    public JSONResult updateIntroduce(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String introduce=(String) map.get("introduce");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(introduce==null || introduce.length()==0){
            return JSONResult.errorMsg("introduce不能为空");
        }
        userService.updateIntroduce(openId,introduce);
        return JSONResult.okMsg("修改自我介绍成功");
    }

    //OK更新性别
    @PostMapping("/updateGender")
    public JSONResult updateGender(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String gender=(String) map.get("gender");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(gender==null || gender.length()==0){
            return JSONResult.errorMsg("gender不能为空");
        }
        userService.updateGender(openId,gender);
        return JSONResult.okMsg("修改性别成功");
    }

    //OK更新昵称
    @PostMapping("/updateNickName")
    public JSONResult updateNickName(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String nickName=(String) map.get("nickName");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(nickName==null || nickName.length()==0){
            return JSONResult.errorMsg("nickName不能为空");
        }
        userService.updateNickName(openId,nickName);
        return JSONResult.okMsg("修改昵称成功");
    }

    /////////////////////////update结束/////////////////////////////

    //获得更改页面中默认的信息
    //OK
    @PostMapping("/getUpdateUserInfo")
    public JSONResult getUpdateUserInfo(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        UserUpdateInfo userUpdateInfo=userService.getUserUpdateInfo(openId);
        return JSONResult.okData(userUpdateInfo);
    }

    //主页面获得简介
    //OK
    @PostMapping("/getSimpleUserInfo")
    public JSONResult getSimpleUserInfo(@RequestBody Map<String, Object> map){
        String openId = (String) map.get("openId");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        //System.out.println(openId);
        UserSimpleInfo queryResult = userService.getSimpleUserInfo(openId);
        //System.out.println(queryResult);
        return JSONResult.okData(queryResult);
    }

    //“我的简介”
    @PostMapping("/getMainUserInfo")
    public JSONResult getMainUserInfo(@RequestBody Map<String, Object> map){
        String openId=(String)map.get("openId");
        UserMainInfo result = userService.getMainUserInfo(openId);
        return JSONResult.okData(result);
    }

    //注册用户
    //OK
    @PostMapping("/registUser")
    public JSONResult saveUser(@RequestBody User user){
        if(user.getOpenId()==null || user.getOpenId().length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(userService.queryUser(user.getOpenId()) !=null){
            return JSONResult.errorMsg("用户已存在");
        }
        if(user.getNickName()==null || user.getNickName().length()==0){
            user.setNickName("默认昵称");
        }
        if(user.getAvatar()==null || user.getAvatar().length()==0) {
            user.setAvatar("默认头像");
        }
        if(user.getGender()==null || user.getGender().length()==0) {
            user.setGender("未知");
        }
        user.setSchool("华南农业大学");
        user.setCollege("外国语学院");
        user.setMajor("默认专业");
        user.setAwardExperience("默认获奖经历");
        user.setContactWay("暂未留下联系方式");
        user.setGrade("2019级");
        user.setIntroduce("暂未留下自我介绍");
        user.setSkills("暂未留下技能");
        //System.out.println(user);
        userService.saveUser(user);
        return JSONResult.okMsg("注册成功");
    }

    //我的收藏竞赛
    @PostMapping("/findMyCollectionCompetition")
    public JSONResult findMyCollectionCompetition(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        System.out.println(openId);
        List<CompetitionSimpleInfo> resultList =  userService.findMyCollectionCompetition(openId);
        return JSONResult.okData(resultList);
    }

    //删除我的收藏竞赛
    @PostMapping("/deleteMyCollectionCompetition")
    public JSONResult deleteMyCollectionCompetition(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String competitionId=(String) map.get("competitionId");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(competitionId==null || competitionId.length()==0){
            return JSONResult.errorMsg("competitionId不能为空");
        }
        System.out.println(openId);
        System.out.println(competitionId);
        userService.deleteMyCollectionCompetition(openId,competitionId);
        return JSONResult.okMsg("删除成功");
    }

    //我的收藏队伍
    @PostMapping("/findMyCollectionTeam")
    public JSONResult findMyCollectionTeam(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        System.out.println(openId);
        List<TeamSimpleInfo> resultList =  userService.findMyCollectionTeam(openId);
        return JSONResult.okData(resultList);
    }

    //删除我的收藏竞赛
    @PostMapping("/deleteMyCollectionTeam")
    public JSONResult deleteMyCollectionTeam(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String teamId=(String) map.get("teamId");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(teamId==null || teamId.length()==0){
            return JSONResult.errorMsg("teamId不能为空");
        }
        System.out.println(openId);
        System.out.println(teamId);
        userService.deleteMyCollectionTeam(openId,teamId);
        return JSONResult.okMsg("删除成功");
    }

    //我的发布
    @PostMapping("/findMyTeam")
    public JSONResult findMyTeam(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        System.out.println(openId);
        List<TeamSimpleInfo> resultList =  userService.findMyTeam(openId);
        return JSONResult.okData(resultList);
    }

    //我的发布
    @PostMapping("/deleteMyTeam")
    public JSONResult deleteMyTeam(@RequestBody Map<String, Object> map){
        String openId=(String) map.get("openId");
        String teamId=(String) map.get("teamId");
        if(openId==null || openId.length()==0){
            return JSONResult.errorMsg("openId不能为空");
        }
        if(teamId==null || teamId.length()==0){
            return JSONResult.errorMsg("teamId不能为空");
        }
        userService.deleteMyTeam(openId,teamId);
        return JSONResult.okMsg("删除成功");
    }

}
