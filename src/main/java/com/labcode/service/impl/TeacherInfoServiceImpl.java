package com.labcode.service.impl;

import com.labcode.dao.TeacherInfoDao;
import com.labcode.dao.base.BaseDao;
import com.labcode.entity.TeacherInfo;
import com.labcode.service.TeacherInfoService;
import com.labcode.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
@Service
public class TeacherInfoServiceImpl extends BaseServiceImpl<TeacherInfo> implements TeacherInfoService {
    @Autowired
    private TeacherInfoDao teacherInfoDao;

    public BaseDao<TeacherInfo> getDao() {
        return teacherInfoDao;
    }
}
