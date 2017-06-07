package com.labcode.service.base;

import java.util.List;

/**
 * Author jiangwj20966 on 2017/6/7.
 */
public interface BaseService<T> {
    List<T> find(T t);
    Integer insert(T t);
    Integer update(T t);
    Integer deleteById(T t);
    T findByID(Integer id);
}
