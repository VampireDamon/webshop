package com.damon.bgmt.service;


public interface SysUtilService {
    /**
     * 根据条件分页查询用户信息列表
     *
     * @param username         用户姓名
     * @param password       密码
     * @return 密码
     */
    int hrReg(String username, String password);
}
