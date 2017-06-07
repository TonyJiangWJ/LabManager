package com.labcode.service.impl;

import com.labcode.dao.TeamStudentRefDao;
import com.labcode.dao.base.BaseDao;
import com.labcode.entity.TeamStudentRef;
import com.labcode.service.TeamStudentRefService;
import com.labcode.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
@Service
public class TeamStudentRefServiceImpl extends BaseServiceImpl<TeamStudentRef> implements TeamStudentRefService {
    @Autowired
    private TeamStudentRefDao teacherInfoDao;

    public BaseDao<TeamStudentRef> getDao() {
        return teacherInfoDao;
    }
}