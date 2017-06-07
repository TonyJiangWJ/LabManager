package com.labcode.service;

import com.labcode.entity.StudentInfo;
import com.labcode.service.base.BaseService;

import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public interface StudentInfoService extends BaseService<StudentInfo> {
    public List<StudentInfo> fuzzyFind(StudentInfo studentInfo);
}
