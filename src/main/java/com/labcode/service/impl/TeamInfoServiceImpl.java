package com.labcode.service.impl;

import com.labcode.dao.TeamInfoDao;
import com.labcode.dao.base.BaseDao;
import com.labcode.entity.TeamInfo;
import com.labcode.service.TeamInfoService;
import com.labcode.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
@Service
public class TeamInfoServiceImpl extends BaseServiceImpl<TeamInfo> implements TeamInfoService {
    @Autowired
    private TeamInfoDao teacherInfoDao;

    public BaseDao<TeamInfo> getDao() {
        return teacherInfoDao;
    }



}