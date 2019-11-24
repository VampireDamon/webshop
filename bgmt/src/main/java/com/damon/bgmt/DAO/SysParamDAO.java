package com.damon.bgmt.DAO;

import com.damon.bgmt.domain.SysParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysParamDAO {

    /**
     * 根据编号分页查询系统配置信息
     *
     * @param name      名称
     * @param configKey 配置键
     * @param pageStart 开始页
     * @param pageSize  页条数
     * @return 系统配置信息列表
     * @throws Exception 异常
     */
    List<SysParam> findAll(@Param("name") String name,
                           @Param("configKey") String configKey,
                           @Param("pageStart") int pageStart, @Param("pageSize") int pageSize) throws Exception;

    /**
     * 查询系统配置总数
     *
     * @param name      名称
     * @param configKey 配置键
     * @return 系统配置总数
     * @throws Exception 异常
     */
    int findTotal(@Param("name") String name, @Param("configKey") String configKey) throws Exception;

    /**
     * 增加系统配置信息
     *
     * @param sysParam 系统配置信息
     * @throws Exception 异常
     */
    void add(SysParam sysParam) throws Exception;

    /**
     * 删除系统配置信息
     *
     * @param id 编号
     * @throws Exception 异常
     */
    void delete(String id) throws Exception;

    /**
     * 更新系统配置信息
     *
     * @param sysParam 系统配置信息
     * @throws Exception 异常
     */
    void update(SysParam sysParam) throws Exception;

    /**
     * 根据编号查询系统配置信息
     *
     * @param id 编号
     * @param configKey 配置键
     * @return SysParam    系统配置对象
     * @throws Exception 异常
     */
    SysParam findObj(@Param("id") String id,@Param("configKey") String configKey) throws Exception;

    /**
     * 根据配置键查询系统配置信息
     *
     * @return List<SysParam>   系统配置列表
     * @throws Exception 异常
     */
    List<SysParam> findList() throws Exception;

}
