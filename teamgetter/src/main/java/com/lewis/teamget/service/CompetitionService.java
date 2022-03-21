package com.lewis.teamget.service;

import com.lewis.teamget.VO.CompetitionMainInfo;
import com.lewis.teamget.VO.CompetitionSimpleInfo;
import com.lewis.teamget.entity.Competition;
import com.lewis.teamget.mapper.CompetitionMapper;
import com.lewis.teamget.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CompetitionService {
    @Autowired
    CompetitionMapper competitionMapper;

    public void addCompetition(Competition competition) {
        competitionMapper.addCompetition(competition);
    }


    public String uploadCover(MultipartFile cover,String saveFileName)  {
        String result;
        try {
            byte[] bytes = cover.getBytes();
            result = QiniuUtils.upload2Qiniu(bytes, saveFileName);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            result="上传失败";
            return result;
        }
    }


    public List<CompetitionSimpleInfo> findCompetitionListByTime() {
        return competitionMapper.findCompetitionListByTime();
    }

    public List<CompetitionSimpleInfo> findCompetitionListByRecommend() {
        return competitionMapper.findCompetitionListByRecommend();
    }

    public CompetitionMainInfo findCompetitionDetailsByCompetitionId(String competitionId) {
        return competitionMapper.findCompetitionDetailsByCompetitionId(competitionId);
    }

    public String findCatalogByCompetitionId(String competitionId) {
        return competitionMapper.findCatalogByCompetitionId(competitionId);
    }

    public void collectCompetition(String openId, String competitionId) {
        competitionMapper.collectCompetition(openId,competitionId);
    }

    public String findSignUpTimeByCompetitionId(String competitionId) {
        return competitionMapper.findSignUpTimeByCompetitionId(competitionId);

    }

    public String findParticipateTimeByCompetitionId(String competitionId) {
        return competitionMapper.findParticipateTimeByCompetitionId(competitionId);
    }

    public String findIsCollectedByOpenId(String openId, String competitionId) {
        int result= competitionMapper.findIsCollectedByOpenId(openId,competitionId);
        if(result==0){
            return "false";
        }else {
            return "true";
        }
    }

    public List<String> findBannerUrlList() {
        return competitionMapper.findBannerUrlList();
    }
}
