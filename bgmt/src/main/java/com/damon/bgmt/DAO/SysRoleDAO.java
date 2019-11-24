package com.damon.bgmt.DAO;

import com.damon.bgmt.domain.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysRoleDAO {

    /**
     * 根据条件查询角色信息列表
     *
     * @param name      角色名称
     * @param isValid   是否启用
     * @param pageStart 开始页
     * @param pageSize  页条数
     * @return 角色信息列表
     * @throws Exception 异常
     */
    List<SysRole> findAll(@Param("name") String name,
                          @Param("isValid") Integer isValid,
                          @Param("pageStart") int pageStart, @Param("pageSize") int pageSize) throws Exception;


    /**
     * 查询角色信息总数
     *
     * @param name    角色名称
     * @param isValid 是否启用
     * @return 角色总数
     * @throws Exception 异常
     */
    int findTotal(@Param("name") String name,
                  @Param("isValid") Integer isValid) throws Exception;

    /**
     * 添加角色信息
     *
     * @param sysRole 角色信息
     * @throws Exception 异常
     */
    void add(SysRole sysRole) throws Exception;

    /**
     * 删除角色信息
     *
     * @param id 编号
     * @throws Exception 异常
     */
    void delete(String id) throws Exception;

    /**
     * 更新角色信息
     *
     * @param sysRole 角色信息
     * @throws Exception 异常
     */
    void update(SysRole sysRole) throws Exception;

    /**
     * 根据编号查询角色信息
     *
     * @param id   编号
     * @param name 角色名称
     * @return SysRole 角色信息对象
     * @throws Exception 异常
     */
    SysRole findObj(@Param("id") String id, @Param("name") String name) throws Exception;

}
