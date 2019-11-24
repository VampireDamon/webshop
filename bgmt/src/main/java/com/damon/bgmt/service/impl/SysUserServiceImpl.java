package com.damon.bgmt.service.impl;

import com.damon.bgmt.DAO.SysUserDAO;
import com.damon.bgmt.domain.SysUser;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysUserService;
import com.damon.bgmt.utils.DamonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Resource
    SysUserDAO sysUserDAO;

    @Override
    public Page<SysUser> findAll(String name, String cardId, String birthday,
                                 String phone, Integer sex, String loginAccount, Integer isValid,
                                 Pageable pageable) throws ApiException {
        List<SysUser> list;
        Page<SysUser> page;
        try {
            list = sysUserDAO.findAll(name, cardId, birthday, phone, sex, loginAccount, isValid, pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            page = new PageImpl<>(list, pageable, sysUserDAO.findTotal(name, cardId, birthday, phone, sex, loginAccount, isValid));
            logger.debug("查询用户信息列表成功");
        } catch (Exception e) {
            logger.error("查询用户信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询用户信息列表异常", HttpStatus.BAD_REQUEST);
        }
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUser sysUser) throws ApiException {
        try {
            if (StringUtils.isBlank(sysUser.getId())) {
                sysUser.setId(DamonUtil.getUUID(true));
            }
            // 密码加盐处理
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            sysUser.setLoginPass(encoder.encode(sysUser.getLoginPass()));
            sysUserDAO.add(sysUser);
            logger.debug("添加用户信息成功" + sysUser.getLoginCode());
        } catch (ApiException e) {
            logger.error("添加用户信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加用户信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加用户信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            sysUserDAO.delete(id);
            logger.debug("删除用户信息成功" + id);
        } catch (Exception e) {
            logger.error("删除用户信息异常", e);
            e.printStackTrace();
            throw new ApiException("删除用户信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUser sysUser) throws ApiException {
        try {
            if (StringUtils.isBlank(sysUser.getId())) {
                throw new ApiException("编号不能为空", HttpStatus.BAD_REQUEST);
            }
            // 密码不可修改，修改密码走其他方法
            sysUserDAO.update(sysUser);
            logger.debug("更新用户信息成功" + sysUser.getId());
        } catch (ApiException e) {
            logger.error("更新用户信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新用户信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新用户信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysUser findObj(String id,String loginAccount) throws ApiException {
        SysUser obj;
        try {
            obj = sysUserDAO.findObj(id,loginAccount);
            logger.debug("查询用户信息成功" + id);
        } catch (Exception e) {
            logger.error("查询用户信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询用户信息异常", HttpStatus.BAD_REQUEST);
        }
        return obj;
    }
}
