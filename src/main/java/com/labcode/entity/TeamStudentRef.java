package com.labcode.entity;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public class TeamStudentRef {
    private Integer id;
    private Integer studentId;
    private Integer teamId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
