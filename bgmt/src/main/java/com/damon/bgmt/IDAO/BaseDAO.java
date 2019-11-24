package com.damon.bgmt.IDAO;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

import java.util.List;
import java.util.Map;

public interface BaseDAO<T> extends Mapper<T>,InsertListMapper<T> {
    //增
    int add(String mapper, Map<String, Object> parameter) throws Exception;

    //改
    int update(String mapper, Map<String, Object> parameter) throws Exception;

    //删
    int delete(String mapper, Map<String, Object> parameter) throws Exception;

    //查
    T findObj(String mapper, Map<String, Object> parameter) throws Exception;

    List<T> findAll(String mapper, Map<String, Object> parameter) throws Exception;

    int findTotal(String mapper, Map<String, Object> parameter) throws Exception;
}
