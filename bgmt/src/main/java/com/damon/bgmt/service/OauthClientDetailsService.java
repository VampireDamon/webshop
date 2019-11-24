package com.damon.bgmt.service;


import com.damon.bgmt.domain.OauthClientDetails;
import com.damon.bgmt.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OauthClientDetailsService {

    /**
     * 根据条件分页查询客户端信息列表
     *
     * @param clientId             客户端名称
     * @param authorizedGrantTypes 客户端支持
     * @param pageable             分页对象
     * @return Page<OauthClientDetails>   客户端信息列表（分页）
     */
    Page<OauthClientDetails> findAll(String clientId, String authorizedGrantTypes,
                                     Pageable pageable) throws ApiException;

    /**
     * 增加客户端信息
     *
     * @param oauthClientDetails 客户端信息
     * @throws ApiException 异常信息
     */
    void add(OauthClientDetails oauthClientDetails) throws ApiException;

    /**
     * 删除客户端信息
     *
     * @param id 编号
     * @throws ApiException 异常信息
     */
    void delete(String id) throws ApiException;

    /**
     * 更新客户端信息
     *
     * @param oauthClientDetails 客户端信息
     * @throws ApiException 异常信息
     */
    void update(OauthClientDetails oauthClientDetails) throws ApiException;

    /**
     * 查询客户端信息
     *
     * @param clientId   编号
     * @return OauthClientDetails 客户端信息
     * @throws ApiException 异常信息
     */
    OauthClientDetails findObj(String clientId) throws ApiException;

}
