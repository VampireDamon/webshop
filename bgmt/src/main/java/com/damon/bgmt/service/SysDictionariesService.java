package com.damon.bgmt.service;


import com.damon.bgmt.domain.SysDictionaries;
import com.damon.bgmt.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SysDictionariesService {

    /**
     * 根据条件查询字典信息列表
     *
     * @param refName  字典名称
     * @param refCode  字典代码
     * @param pageable 分页对象
     * @return 部门信息列表（分页）
     * @throws ApiException 异常信息
     */
    Page<SysDictionaries> findAll(String refName, String refCode, Pageable pageable) throws ApiException;

    /**
     * 添加字典信息
     *
     * @param sysDictionaries 字典对象
     * @throws ApiException 异常信息
     */
    void add(SysDictionaries sysDictionaries) throws ApiException;

    /**
     * 删除字典项信息
     *
     * @param code 字典代码
     * @param refCode 父字典代码
     * @throws ApiException 异常信息
     */
    void delete(String code,String refCode) throws ApiException;

    /**
     * 修改字典项信息
     *
     * @param sysDictionaries 字典对象
     * @throws ApiException 异常信息
     */
    void update(SysDictionaries sysDictionaries) throws ApiException;

    /**
     * 通过父节点获取字典内容列表信息
     *
     * @param code 字典代码
     * @return SysDictionaries 字典对象
     * @throws ApiException 异常信息
     */
    SysDictionaries findObj(String code) throws ApiException;

    /**
     * 通过父节点获取字典内容列表信息
     *
     * @param refCode 父字典代码
     * @return List<SysDictionaries> 字典列表
     * @throws ApiException 异常信息
     */
    List<SysDictionaries> findList(String refCode) throws ApiException;

}
