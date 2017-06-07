package com.labcode.response;

import com.labcode.entity.TeamInfo;

import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public class TeacherInfoResponse extends BaseResponse {
    private Integer teacherId;
    private List<Integer> teamIdList;
    private String teacherNo;
    private String teacherName;
    private String gender;
    private List<TeamInfo> teamInfoList;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public List<Integer> getTeamIdList() {
        return teamIdList;
    }

    public void setTeamIdList(List<Integer> teamIdList) {
        this.teamIdList = teamIdList;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<TeamInfo> getTeamInfoList() {
        return teamInfoList;
    }

    public void setTeamInfoList(List<TeamInfo> teamInfoList) {
        this.teamInfoList = teamInfoList;
    }
}
