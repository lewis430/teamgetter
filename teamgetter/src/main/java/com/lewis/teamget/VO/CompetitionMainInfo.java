package com.lewis.teamget.VO;

public class CompetitionMainInfo {
    private String competitionId;
    private String cover;
    private String title;
    private String deadline;
    private String signUpTime;
    private String participateTime;
    private String summary;
    private String college;
    private String level;
    private String catalog;
    private String htmlContent;
    //官方链接
    private String link;
    //是否被收藏
    private String isCollected;

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(String isCollected) {
        this.isCollected = isCollected;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
