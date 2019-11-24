package com.damon.bgmt.service;


import com.damon.bgmt.domain.SysParam;
import com.damon.bgmt.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysParamService {

    /**
     * 根据条件分页查询系统配置信息列表
     *
     * @param name      名称
     * @param configKey 配置键
     * @param pageable  分页对象
     * @return Page<SysParam>   系统配置信息列表（分页）
     */
    Page<SysParam> findAll(String name, String configKey, Pageable pageable) throws ApiException;

    /**
     * 增加系统配置信息
     *
     * @param sysParam 系统配置信息
     * @throws ApiException 异常信息
     */
    void add(SysParam sysParam) throws ApiException;

    /**
     * 删除系统配置信息
     *
     * @param id 编号
     * @throws ApiException 异常信息
     */
    void delete(String id) throws ApiException;

    /**
     * 更新系统配置信息
     *
     * @param sysParam 系统配置信息
     * @throws ApiException 异常信息
     */
    void update(SysParam sysParam) throws ApiException;

    /**
     * 查询系统配置信息
     *
     * @param id 编号
     * @param configKey 配置键
     * @return SysParam 系统配置对象
     * @throws ApiException 异常信息
     */
    SysParam findObj(String id,String configKey) throws ApiException;

}
