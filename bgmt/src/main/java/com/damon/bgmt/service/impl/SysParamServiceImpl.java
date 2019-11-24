package com.damon.bgmt.service.impl;

import com.damon.bgmt.DAO.SysParamDAO;
import com.damon.bgmt.domain.SysParam;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysParamService;
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
public class SysParamServiceImpl implements SysParamService {

    private static final Logger logger = LoggerFactory.getLogger(SysParamServiceImpl.class);

    @Resource
    SysParamDAO sysParamDAO;

    @Override
    public Page<SysParam> findAll(String name, String configKey, Pageable pageable) throws ApiException {
        List<SysParam> list;
        Page<SysParam> page;
        try {
            list = sysParamDAO.findAll(name, configKey, pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            page = new PageImpl<>(list, pageable, sysParamDAO.findTotal(name, configKey));
            logger.debug("查询系统配置信息列表成功");
        } catch (Exception e) {
            logger.error("查询系统配置信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询系统配置信息列表异常", HttpStatus.BAD_REQUEST);
        }
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysParam sysParam) throws ApiException {
        try {
            if (StringUtils.isBlank(sysParam.getId())) {
                sysParam.setId(DamonUtil.getUUID(true));
            }
            if (StringUtils.isBlank(sysParam.getConfigKey())) {
                throw new ApiException("配置键不能为空", HttpStatus.BAD_REQUEST);
            }
            if (sysParamDAO.findObj(null,sysParam.getConfigKey()) != null) {
                throw new ApiException("配置键重复", HttpStatus.BAD_REQUEST);
            }
            sysParamDAO.add(sysParam);
            logger.debug("添加系统配置信息成功" + sysParam.getConfigKey());
        } catch (ApiException e) {
            logger.error("添加系统配置信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加系统配置信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加系统配置信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            sysParamDAO.delete(id);
            logger.debug("删除系统配置信息成功" + id);
        } catch (Exception e) {
            logger.error("删除系统配置信息异常", e);
            e.printStackTrace();
            throw new ApiException("删除系统配置信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysParam sysParam) throws ApiException {
        try {
            if (StringUtils.isBlank(sysParam.getId())) {
                throw new ApiException("编号不能为空", HttpStatus.BAD_REQUEST);
            }
            if (StringUtils.isBlank(sysParam.getConfigKey())) {
                throw new ApiException("配置键不能为空", HttpStatus.BAD_REQUEST);
            }
            SysParam sysParamCheck = sysParamDAO.findObj(null,sysParam.getConfigKey());
            if (sysParamCheck != null && !sysParamCheck.getId().equals(sysParam.getId())) {
                throw new ApiException("配置键重复", HttpStatus.BAD_REQUEST);
            }
            sysParamDAO.update(sysParam);
            logger.debug("更新系统配置信息成功" + sysParam.getId());
        } catch (ApiException e) {
            logger.error("更新系统配置信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新系统配置信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新系统配置信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysParam findObj(String id,String configKey) throws ApiException {
        SysParam obj;
        try {
            obj = sysParamDAO.findObj(id,configKey);
            logger.debug("查询系统配置信息成功" + id+"|"+configKey);
        } catch (Exception e) {
            logger.error("查询系统配置信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询系统配置信息异常", HttpStatus.BAD_REQUEST);
        }
        return obj;
    }
}
