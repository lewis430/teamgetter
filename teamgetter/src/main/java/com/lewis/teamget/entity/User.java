package com.lewis.teamget.entity;

import lombok.Data;

@Data

public class User {

    private String openId;

    private String avatar;
    private String nickName;
    private String school;//学校
    private String college;//学院
    private String major;//专业

    private String gender;
    private String introduce;//自我介绍
    private String grade;//年级
    private String contactWay;//联系方式
    private String awardExperience;//获奖经历
    private String skills;//我的技能
}
