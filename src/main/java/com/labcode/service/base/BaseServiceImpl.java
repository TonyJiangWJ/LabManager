package com.labcode.service.base;

import com.labcode.dao.base.BaseDao;

import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    abstract public BaseDao<T> getDao();

    public List<T> find(T t) {
        return getDao().find(t);
    }

    public Integer insert(T t) {
        return getDao().insert(t);
    }

    public Integer update(T t) {
        return getDao().update(t);
    }

    public Integer deleteById(T t) {
        return getDao().deleteById(t);
    }

    public T findByID(Integer id) {
        return getDao().findById(id);
    }


}
