package com.labcode.response;

import com.labcode.entity.TeamInfo;

import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public class StudentInfoResponse extends BaseResponse {
    private Integer studentId;
    private String studentName;
    private String gender;
    private String studentNo;
    private String email;
    private List<TeamInfo> teamInfo;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TeamInfo> getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(List<TeamInfo> teamInfo) {
        this.teamInfo = teamInfo;
    }
}
