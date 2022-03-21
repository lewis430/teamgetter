package com.lewis.teamget.controller.bak;

import com.lewis.teamget.entity.Competition;
import com.lewis.teamget.entity.User;
import com.lewis.teamget.service.CompetitionService;
import com.lewis.teamget.service.UserService;
import com.lewis.teamget.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/bak")
public class BakCompetitionController {

    @Autowired
    CompetitionService competitionService;

    @Autowired
    UserService userService;

    //发布比赛
    //差图片上传
    @PostMapping("/addCompetition")
    public JSONResult addCompetition(@RequestBody Competition competition){
        Date nowTime=new Date();
        SimpleDateFormat createDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createTime=createDateFormat.format(nowTime);
        competition.setCreateTime(createTime);
        System.out.println(competition);
        competitionService.addCompetition(competition);
        return JSONResult.okMsg("新增竞赛成功");
    }

    //图片上传，在上传之后返回文件的访问路径
    @PostMapping("/uploadCover")
    public JSONResult uploadCover(@RequestParam(name = "cover") MultipartFile cover){
//        User user = userService.queryUser(openId);
//        if(user==null){
//            return JSONResult.errorMsg("请登录");
//        }
        String saveFileName = UUID.randomUUID().toString().replace("-","");
        String pictureUrl = competitionService.uploadCover(cover,saveFileName);
        return JSONResult.okData(pictureUrl);
    }
}
