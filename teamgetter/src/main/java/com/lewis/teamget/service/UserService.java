package com.lewis.teamget.service;

import com.lewis.teamget.VO.*;
import com.lewis.teamget.entity.User;
import com.lewis.teamget.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User queryUser(String openId){

        return userMapper.queryUser(openId);
    }

    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    public UserSimpleInfo getSimpleUserInfo(String openId) {
        return userMapper.getSimpleUserInfo(openId);
    }

    public void updateNickName(String openId, String nickName) {
        userMapper.updateNickName(openId,nickName);
    }

    public void updateGender(String openId, String gender) {
        userMapper.updateGender(openId,gender);
    }

    public void updateIntroduce(String openId, String introduce) {
        userMapper.updateIntroduce(openId,introduce);
    }

    public void updateSchool(String openId, String school) {
        userMapper.updateSchool(openId,school);
    }

    public void updateCollege(String openId, String college) {
        userMapper.updateCollege(openId,college);
    }

    public void updateGrade(String openId, String grade) {
        userMapper.updateGrade(openId,grade);
    }

    public void updateContactWay(String openId, String contactWay) {
        userMapper.updateContactWay(openId,contactWay);
    }

    public void updateAwardExperience(String openId, String awardExperience) {
        userMapper.updateAwardExperience(openId,awardExperience);
    }

    public void updateMajor(String openId, String major) {
        userMapper.updateMajor(openId,major);
    }

    public void updateSkills(String openId, String skills) {
        userMapper.updateSkills(openId,skills);
    }

    public UserUpdateInfo getUserUpdateInfo(String openId) {
        return userMapper.getUserUpdateInfo(openId);
    }

    public UserMainInfo getMainUserInfo(String openId) {
        return userMapper.getMainUserInfo(openId);
    }

    public List<CompetitionSimpleInfo> findMyCollectionCompetition(String openId) {
        return userMapper.findMyCollectionCompetition(openId);
    }

    public void deleteMyCollectionCompetition(String openId, String competitionId) {
        userMapper.deleteMyCollectionCompetition(openId,competitionId);
    }

    public List<TeamSimpleInfo> findMyCollectionTeam(String openId) {
        return userMapper.findMyCollectionTeam(openId);
    }

    public void deleteMyCollectionTeam(String openId, String teamId) {
        userMapper.deleteMyCollectionTeam(openId,teamId);
    }

    public List<TeamSimpleInfo> findMyTeam(String openId) {
        return userMapper.findMyTeam(openId);
    }

    public void deleteMyTeam(String openId, String teamId) {
        userMapper.deleteMyTeam(openId,teamId);
    }
}
