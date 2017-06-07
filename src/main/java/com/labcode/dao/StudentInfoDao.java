package com.labcode.dao;

import com.labcode.dao.base.BaseDao;
import com.labcode.entity.StudentInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
@Repository
public interface StudentInfoDao extends BaseDao<StudentInfo>{
    List<StudentInfo> fuzzyFind(StudentInfo studentInfo);
}
