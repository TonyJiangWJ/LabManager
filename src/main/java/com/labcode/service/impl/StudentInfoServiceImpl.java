package com.labcode.service.impl;

import com.labcode.dao.StudentInfoDao;
import com.labcode.dao.base.BaseDao;
import com.labcode.entity.StudentInfo;
import com.labcode.service.StudentInfoService;
import com.labcode.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
@Service
public class StudentInfoServiceImpl extends BaseServiceImpl<StudentInfo> implements StudentInfoService {
    @Autowired
    private StudentInfoDao studentInfoDao;

    public BaseDao<StudentInfo> getDao() {
        return studentInfoDao;
    }

    public List<StudentInfo> fuzzyFind(StudentInfo studentInfo){
        return studentInfoDao.fuzzyFind(studentInfo);
    }
}
