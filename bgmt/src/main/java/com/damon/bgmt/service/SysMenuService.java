package com.damon.bgmt.service;


import com.damon.bgmt.domain.SysMenu;
import com.damon.bgmt.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysMenuService {

    /**
     * 根据条件分页查询菜单信息列表
     *
     * @param name     菜单名称
     * @param isValid  是否启用
     * @param pageable 分页对象
     * @return Page<SysMenu>   菜单信息列表（分页）
     */
    Page<SysMenu> findAll(String name, Integer isValid,
                          Pageable pageable) throws ApiException;

    /**
     * 增加菜单信息
     *
     * @param sysMenu 菜单信息
     * @throws ApiException 异常信息
     */
    void add(SysMenu sysMenu) throws ApiException;

    /**
     * 删除菜单信息
     *
     * @param id 编号
     * @throws ApiException 异常信息
     */
    void delete(String id) throws ApiException;

    /**
     * 更新菜单信息
     *
     * @param sysMenu 菜单信息
     * @throws ApiException 异常信息
     */
    void update(SysMenu sysMenu) throws ApiException;

    /**
     * 查询菜单信息
     *
     * @param id   编号
     * @param name 菜单名称
     * @return SysMenu 菜单信息
     * @throws ApiException 异常信息
     */
    SysMenu findObj(String id, String name) throws ApiException;

}
