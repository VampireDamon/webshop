package com.damon.bgmt.DAO;

import com.damon.bgmt.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysUserDAO {

    /**
     * 根据条件查询人员信息列表
     *
     * @param name         用户姓名
     * @param cardId       身份证号
     * @param birthday     生日
     * @param phone        手机号
     * @param sex          性别
     * @param loginAccount 登录账号
     * @param isValid      是否启用
     * @param pageStart    开始页
     * @param pageSize     页条数
     * @return 人员信息列表
     * @throws Exception 异常
     */
    List<SysUser> findAll(@Param("name") String name,
                          @Param("cardId") String cardId,
                          @Param("birthday") String birthday,
                          @Param("phone") String phone,
                          @Param("sex") Integer sex,
                          @Param("loginAccount") String loginAccount,
                          @Param("isValid") Integer isValid,
                          @Param("pageStart") int pageStart, @Param("pageSize") int pageSize) throws Exception;


    /**
     * 查询人员总数
     *
     * @param name         用户姓名
     * @param cardId       身份证号
     * @param birthday     生日
     * @param phone        手机号
     * @param sex          性别
     * @param loginAccount 登录账号
     * @param isValid      是否启用
     * @return 人员总数
     * @throws Exception 异常
     */
    int findTotal(@Param("name") String name,
                  @Param("cardId") String cardId,
                  @Param("birthday") String birthday,
                  @Param("phone") String phone,
                  @Param("sex") Integer sex,
                  @Param("loginAccount") String loginAccount,
                  @Param("isValid") Integer isValid) throws Exception;

    /**
     * 添加人员信息
     *
     * @param sysUser 人员信息
     * @throws Exception 异常
     */
    void add(SysUser sysUser) throws Exception;

    /**
     * 删除人员信息
     *
     * @param id 编号
     * @throws Exception 异常
     */
    void delete(String id) throws Exception;

    /**
     * 更新人员信息
     *
     * @param sysUser 人员信息
     * @throws Exception 异常
     */
    void update(SysUser sysUser) throws Exception;

    /**
     * 根据编号查询人员信息
     *
     * @param id 编号
     * @param loginAccount 登录账号
     * @return SysUser 人员信息对象
     * @throws Exception 异常
     */
    SysUser findObj(@Param("id") String id,@Param("loginAccount") String loginAccount) throws Exception;

}
