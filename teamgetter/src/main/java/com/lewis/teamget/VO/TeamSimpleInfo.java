package com.lewis.teamget.VO;

import lombok.Data;

@Data
public class TeamSimpleInfo {
    private String teamId;
    private String cover;
    private String people;
    private String limits;
    private String title;
    private String summary;
    //0表示审核中，1表示审核通过，2表示审核未通过
    private String show;
}
