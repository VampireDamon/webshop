package com.damon.bgmt.service;


import com.damon.bgmt.domain.SysRole;
import com.damon.bgmt.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysRoleService {

    /**
     * 根据条件分页查询角色信息列表
     *
     * @param name     角色名称
     * @param isValid  是否启用
     * @param pageable 分页对象
     * @return Page<SysRole>   角色信息列表（分页）
     */
    Page<SysRole> findAll(String name, Integer isValid,
                          Pageable pageable) throws ApiException;

    /**
     * 增加角色信息
     *
     * @param sysRole 角色信息
     * @throws ApiException 异常信息
     */
    void add(SysRole sysRole) throws ApiException;

    /**
     * 删除角色信息
     *
     * @param id 编号
     * @throws ApiException 异常信息
     */
    void delete(String id) throws ApiException;

    /**
     * 更新角色信息
     *
     * @param sysRole 角色信息
     * @throws ApiException 异常信息
     */
    void update(SysRole sysRole) throws ApiException;

    /**
     * 查询角色信息
     *
     * @param id   编号
     * @param name 角色名称
     * @return SysRole 角色信息
     * @throws ApiException 异常信息
     */
    SysRole findObj(String id, String name) throws ApiException;

}
