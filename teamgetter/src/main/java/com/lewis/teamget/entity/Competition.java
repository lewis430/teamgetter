package com.lewis.teamget.entity;

import com.github.rjeschke.txtmark.Processor;



public class  Competition {
    //比赛id
    private String competitionId;
    //创建者Id
    private String openId;
    //标题
    private String title;
    //院校
    private String college;
    //级别(院级，校级)
    private String level;
    //封面
    private String cover;
    //需求
    private String mkContent;
    private String htmlContent;
    //简介
    private String summary;
    //是否删除
    private String deleted;
    //推荐级别
    private String recommend;
    //创建时间
    private String createTime;
    //官方链接
    private String link;
    //报名时间
    private String signUpTime;
    //参赛时间
    private String participateTime;
    //截止日期
    private String deadline;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getSignUpTime() {
        return signUpTime;
    }

    public void setSignUpTime(String signUpTime) {
        this.signUpTime = signUpTime;
    }

    public String getParticipateTime() {
        return participateTime;
    }

    public void setParticipateTime(String participateTime) {
        this.participateTime = participateTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMkContent() {
        return mkContent;
    }

    public void setMkContent(String mkContent) {
        this.mkContent = mkContent;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
