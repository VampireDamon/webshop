package com.damon.bgmt.service.impl;

import com.damon.bgmt.IDAO.BaseDAO;
import com.damon.bgmt.service.BaseService;
import io.swagger.annotations.Example;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

public abstract class BaseServiceImpl<T, Id> implements BaseService<T, Id> {

    protected abstract BaseDAO<T> getDao();

    @Override
    @Transactional
    public int save(T t) {
        return getDao().insertSelective(t);
    }

    @Override
    @Transactional
    public int saveAll(List<T> list) {
        return getDao().insertList(list);
    }

    @Override
    @Transactional
    public int delete(T t) {
        return getDao().delete(t);
    }

    @Override
    @Transactional
    public int deleteById(Id id) {
        return getDao().deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int update(T t) {
        return getDao().updateByPrimaryKey(t);
    }

    @Override
    public T getById(Id id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    public List<T> getAll() {
        return getDao().selectAll();
    }

    @Override
    public List<T> searchByExample(Example example) {
        return Collections.emptyList();
    }
}
