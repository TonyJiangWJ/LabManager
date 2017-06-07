package com.labcode.request;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public class DelStudentFromTeamReq extends BaseRequest {

    private Integer studentId;
    private Integer teamId;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
