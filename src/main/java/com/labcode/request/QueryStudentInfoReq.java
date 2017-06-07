package com.labcode.request;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public class QueryStudentInfoReq extends BaseRequest {
    private Integer studentId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
