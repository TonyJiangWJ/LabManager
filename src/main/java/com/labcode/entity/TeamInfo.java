package com.labcode.entity;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public class TeamInfo {
    private Integer teamId;
    private String teamName;
    private Integer teamTeacherId;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTeamTeacherId() {
        return teamTeacherId;
    }

    public void setTeamTeacherId(Integer teamTeacherId) {
        this.teamTeacherId = teamTeacherId;
    }
}
