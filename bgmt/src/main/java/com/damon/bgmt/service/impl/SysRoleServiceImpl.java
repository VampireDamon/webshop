package com.damon.bgmt.service.impl;

import com.damon.bgmt.DAO.SysRoleDAO;
import com.damon.bgmt.domain.SysRole;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysRoleService;
import com.damon.bgmt.utils.DamonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    private static final Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);

    @Resource
    SysRoleDAO sysRoleDAO;

    @Override
    public Page<SysRole> findAll(String name, Integer isValid,
                                 Pageable pageable) throws ApiException {
        List<SysRole> list;
        Page<SysRole> page;
        try {
            list = sysRoleDAO.findAll(name, isValid, pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            page = new PageImpl<>(list, pageable, sysRoleDAO.findTotal(name, isValid));
            logger.debug("查询角色信息列表成功");
        } catch (Exception e) {
            logger.error("查询角色信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询角色信息列表异常", HttpStatus.BAD_REQUEST);
        }
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysRole sysRole) throws ApiException {
        try {
            if (StringUtils.isBlank(sysRole.getId())) {
                sysRole.setId(DamonUtil.getUUID(true));
            }
            sysRoleDAO.add(sysRole);
            logger.debug("添加角色信息成功" + sysRole.getName());
        } catch (ApiException e) {
            logger.error("添加角色信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加角色信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加角色信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            sysRoleDAO.delete(id);
            logger.debug("删除角色信息成功" + id);
        } catch (Exception e) {
            logger.error("删除角色信息异常", e);
            e.printStackTrace();
            throw new ApiException("删除角色信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRole sysRole) throws ApiException {
        try {
            if (StringUtils.isBlank(sysRole.getId())) {
                throw new ApiException("编号不能为空", HttpStatus.BAD_REQUEST);
            }
            // 密码不可修改，修改密码走其他方法
            sysRoleDAO.update(sysRole);
            logger.debug("更新角色信息成功" + sysRole.getId());
        } catch (ApiException e) {
            logger.error("更新角色信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新角色信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新角色信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysRole findObj(String id, String loginAccount) throws ApiException {
        SysRole obj;
        try {
            obj = sysRoleDAO.findObj(id, loginAccount);
            logger.debug("查询角色信息成功" + id);
        } catch (Exception e) {
            logger.error("查询角色信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询角色信息异常", HttpStatus.BAD_REQUEST);
        }
        return obj;
    }
}
