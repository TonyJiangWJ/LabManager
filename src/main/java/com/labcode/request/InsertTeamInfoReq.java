package com.labcode.request;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public class InsertTeamInfoReq extends BaseRequest {
    private String teamName;
    private Integer teacherId;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
