package com.damon.bgmt.service.impl;

import com.damon.bgmt.DAO.SysMenuDAO;
import com.damon.bgmt.domain.SysMenu;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysMenuService;
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
public class SysMenuServiceImpl implements SysMenuService {

    private static final Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);

    @Resource
    SysMenuDAO sysMenuDAO;

    @Override
    public Page<SysMenu> findAll(String name, Integer isValid,
                                 Pageable pageable) throws ApiException {
        List<SysMenu> list;
        Page<SysMenu> page;
        try {
            list = sysMenuDAO.findAll(name, isValid, pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            page = new PageImpl<>(list, pageable, sysMenuDAO.findTotal(name, isValid));
            logger.debug("查询菜单信息列表成功");
        } catch (Exception e) {
            logger.error("查询菜单信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询菜单信息列表异常", HttpStatus.BAD_REQUEST);
        }
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysMenu sysMenu) throws ApiException {
        try {
            if (StringUtils.isBlank(sysMenu.getId())) {
                sysMenu.setId(DamonUtil.getUUID(true));
            }
            sysMenuDAO.add(sysMenu);
            logger.debug("添加菜单信息成功" + sysMenu.getName());
        } catch (ApiException e) {
            logger.error("添加菜单信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加菜单信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加菜单信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            sysMenuDAO.delete(id);
            logger.debug("删除菜单信息成功" + id);
        } catch (Exception e) {
            logger.error("删除菜单信息异常", e);
            e.printStackTrace();
            throw new ApiException("删除菜单信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysMenu sysMenu) throws ApiException {
        try {
            if (StringUtils.isBlank(sysMenu.getId())) {
                throw new ApiException("编号不能为空", HttpStatus.BAD_REQUEST);
            }
            // 密码不可修改，修改密码走其他方法
            sysMenuDAO.update(sysMenu);
            logger.debug("更新菜单信息成功" + sysMenu.getId());
        } catch (ApiException e) {
            logger.error("更新菜单信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新菜单信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新菜单信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysMenu findObj(String id, String loginAccount) throws ApiException {
        SysMenu obj;
        try {
            obj = sysMenuDAO.findObj(id, loginAccount);
            logger.debug("查询菜单信息成功" + id);
        } catch (Exception e) {
            logger.error("查询菜单信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询菜单信息异常", HttpStatus.BAD_REQUEST);
        }
        return obj;
    }
}
