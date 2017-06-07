package com.labcode.request;

/**
 * Author by TonyJiang on 2017/6/7.
 */
public class ListStudentReq extends BaseRequest {
    private Integer teamId;
    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
