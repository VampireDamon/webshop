package com.damon.bgmt.DAO;

import com.damon.bgmt.domain.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysMenuDAO {

    /**
     * 根据条件查询菜单信息列表
     *
     * @param name      菜单名称
     * @param isValid   是否启用
     * @param pageStart 开始页
     * @param pageSize  页条数
     * @return 菜单信息列表
     * @throws Exception 异常
     */
    List<SysMenu> findAll(@Param("name") String name,
                          @Param("isValid") Integer isValid,
                          @Param("pageStart") int pageStart, @Param("pageSize") int pageSize) throws Exception;


    /**
     * 查询菜单信息总数
     *
     * @param name    菜单名称
     * @param isValid 是否启用
     * @return 菜单总数
     * @throws Exception 异常
     */
    int findTotal(@Param("name") String name,
                  @Param("isValid") Integer isValid) throws Exception;

    /**
     * 添加菜单信息
     *
     * @param sysMenu 菜单信息
     * @throws Exception 异常
     */
    void add(SysMenu sysMenu) throws Exception;

    /**
     * 删除菜单信息
     *
     * @param id 编号
     * @throws Exception 异常
     */
    void delete(String id) throws Exception;

    /**
     * 更新菜单信息
     *
     * @param sysMenu 菜单信息
     * @throws Exception 异常
     */
    void update(SysMenu sysMenu) throws Exception;

    /**
     * 根据编号查询菜单信息
     *
     * @param id   编号
     * @param name 菜单名称
     * @return SysMenu 菜单信息对象
     * @throws Exception 异常
     */
    SysMenu findObj(@Param("id") String id, @Param("name") String name) throws Exception;

}
