package com.damon.bgmt.service;


import com.damon.bgmt.domain.SysUser;
import com.damon.bgmt.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SysUserService {

    /**
     * 根据条件分页查询用户信息列表
     *
     * @param name         用户姓名
     * @param cardId       身份证号
     * @param birthday     生日
     * @param phone        手机号
     * @param sex          性别
     * @param loginAccount 登录账号
     * @param isValid      是否启用
     * @param pageable     分页对象
     * @return Page<SysUser>   用户信息列表（分页）
     */
    Page<SysUser> findAll(String name, String cardId, String birthday,
                          String phone, Integer sex, String loginAccount, Integer isValid,
                          Pageable pageable) throws ApiException;

    /**
     * 增加用户信息
     *
     * @param sysUser 用户信息
     * @throws ApiException 异常信息
     */
    void add(SysUser sysUser) throws ApiException;

    /**
     * 删除用户信息
     *
     * @param id 编号
     * @throws ApiException 异常信息
     */
    void delete(String id) throws ApiException;

    /**
     * 更新用户信息
     *
     * @param sysUser 用户信息
     * @throws ApiException 异常信息
     */
    void update(SysUser sysUser) throws ApiException;

    /**
     * 查询用户信息
     *
     * @param id 编号
     * @param loginAccount 登录账号
     * @return SysUser 用户信息
     * @throws ApiException 异常信息
     */
    SysUser findObj(String id,String loginAccount) throws ApiException;

}
