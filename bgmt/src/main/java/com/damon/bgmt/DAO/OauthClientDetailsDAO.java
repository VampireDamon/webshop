package com.damon.bgmt.DAO;

import com.damon.bgmt.domain.OauthClientDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OauthClientDetailsDAO {

    /**
     * 根据条件查询客户端信息列表
     *
     * @param clientId      客户端名称
     * @param authorizedGrantTypes   客户端支持
     * @param pageStart 开始页
     * @param pageSize  页条数
     * @return 客户端信息列表
     * @throws Exception 异常
     */
    List<OauthClientDetails> findAll(@Param("clientId") String clientId,
                                     @Param("authorizedGrantTypes") String authorizedGrantTypes,
                                     @Param("pageStart") int pageStart, @Param("pageSize") int pageSize) throws Exception;


    /**
     * 查询客户端信息总数
     *
     * @param clientId      客户端名称
     * @param authorizedGrantTypes   客户端支持
     * @return 客户端总数
     * @throws Exception 异常
     */
    int findTotal(@Param("clientId") String clientId,
                  @Param("authorizedGrantTypes") String authorizedGrantTypes) throws Exception;

    /**
     * 添加客户端信息
     *
     * @param oauthClientDetails 客户端信息
     * @throws Exception 异常
     */
    void add(OauthClientDetails oauthClientDetails) throws Exception;

    /**
     * 删除客户端信息
     *
     * @param clientId 客户端编号
     * @throws Exception 异常
     */
    void delete(String clientId) throws Exception;

    /**
     * 更新客户端信息
     *
     * @param oauthClientDetails 客户端信息
     * @throws Exception 异常
     */
    void update(OauthClientDetails oauthClientDetails) throws Exception;

    /**
     * 根据编号查询客户端信息
     *
     * @param clientId   客户端编号
     * @return SysRole 客户端信息对象
     * @throws Exception 异常
     */
    OauthClientDetails findObj(@Param("clientId") String clientId) throws Exception;

}
