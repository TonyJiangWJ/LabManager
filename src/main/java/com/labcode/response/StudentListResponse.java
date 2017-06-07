package com.labcode.response;

import com.labcode.entity.StudentInfo;

import java.util.List;

/**
 * Author by TonyJiang on 2017/6/7.
 */
public class StudentListResponse extends BaseResponse {
    private List<StudentInfo> studentInfos;

    public List<StudentInfo> getStudentInfos() {
        return studentInfos;
    }

    public void setStudentInfos(List<StudentInfo> studentInfos) {
        this.studentInfos = studentInfos;
    }
}
