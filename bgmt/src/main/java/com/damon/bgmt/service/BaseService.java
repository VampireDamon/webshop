package com.damon.bgmt.service;

import io.swagger.annotations.Example;
import java.util.List;

public interface BaseService <T, Id>{
    int save(T t);

    int delete(T t);

    int deleteById(Id id);

    int update(T t);

    T getById(Id id);

    List<T> getAll();

    int saveAll(List<T> list);

    List<T> searchByExample(Example example);
}
