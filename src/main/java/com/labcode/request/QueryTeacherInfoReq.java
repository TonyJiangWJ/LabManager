package com.labcode.request;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public class QueryTeacherInfoReq extends BaseRequest {
    private Integer teacherId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
