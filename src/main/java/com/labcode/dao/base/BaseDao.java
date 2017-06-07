package com.labcode.dao.base;

import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public interface BaseDao<T> {
    Integer insert(T t);
    Integer update(T t);
    List<T> find(T t);
    Integer deleteById(T t);
    T findById(Integer id);
}
