package com.lewis.teamget.mapper;

import com.lewis.teamget.VO.*;
import com.lewis.teamget.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //查询用户
    User queryUser(String openId);
    //保存用户
    void saveUser(User user);
    //查询用户简略信息
    UserSimpleInfo getSimpleUserInfo(String openId);
    //更新昵称
    void updateNickName(String openId, String nickName);
    //更新性别
    void updateGender(String openId, String gender);
    //更新简介
    void updateIntroduce(String openId, String introduce);
    //更新学校
    void updateSchool(String openId, String school);
    //更新学院
    void updateCollege(String openId, String college);
    //更新年级
    void updateGrade(String openId, String grade);
    //更新联系方式
    void updateContactWay(String openId, String contactWay);
    //更新获奖经历
    void updateAwardExperience(String openId, String awardExperience);
    //更新专业
    void updateMajor(String openId, String major);
    //更新技能
    void updateSkills(String openId, String skills);
    //查询用户更新列表
    UserUpdateInfo getUserUpdateInfo(String openId);
    //更新用户详细信息
    UserMainInfo getMainUserInfo(String openId);
    //查询我收藏的比赛
    List<CompetitionSimpleInfo> findMyCollectionCompetition(String openId);
    //删除我收藏的比赛
    void deleteMyCollectionCompetition(String openId, String competitionId);
    //获得我收藏的队伍
    List<TeamSimpleInfo> findMyCollectionTeam(String openId);
    //删除我收藏的队伍
    void deleteMyCollectionTeam(String openId, String teamId);
    //查询我创建的队伍
    List<TeamSimpleInfo> findMyTeam(String openId);
    //删除我创建的队伍
    void deleteMyTeam(String openId, String teamId);
}