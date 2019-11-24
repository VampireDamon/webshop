package com.damon.bgmt.service.impl;

import com.damon.bgmt.DAO.OauthClientDetailsDAO;
import com.damon.bgmt.domain.OauthClientDetails;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.OauthClientDetailsService;
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
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(OauthClientDetailsServiceImpl.class);

    @Resource
    OauthClientDetailsDAO oauthClientDetailsDAO;

    @Override
    public Page<OauthClientDetails> findAll(String clientId, String authorizedGrantTypes,
                                            Pageable pageable) throws ApiException {
        List<OauthClientDetails> list;
        Page<OauthClientDetails> page;
        try {
            list = oauthClientDetailsDAO.findAll(clientId, authorizedGrantTypes, pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            page = new PageImpl<>(list, pageable, oauthClientDetailsDAO.findTotal(clientId, authorizedGrantTypes));
            logger.debug("查询客户端信息列表成功");
        } catch (Exception e) {
            logger.error("查询客户端信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询客户端信息列表异常", HttpStatus.BAD_REQUEST);
        }
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(OauthClientDetails oauthClientDetails) throws ApiException {
        try {
            oauthClientDetailsDAO.add(oauthClientDetails);
            logger.debug("添加客户端信息成功" + oauthClientDetails.getClientId());
        } catch (ApiException e) {
            logger.error("添加客户端信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加客户端信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加客户端信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            oauthClientDetailsDAO.delete(id);
            logger.debug("删除客户端信息成功" + id);
        } catch (Exception e) {
            logger.error("删除客户端信息异常", e);
            e.printStackTrace();
            throw new ApiException("删除客户端信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(OauthClientDetails oauthClientDetails) throws ApiException {
        try {
            if (StringUtils.isBlank(oauthClientDetails.getClientId())) {
                throw new ApiException("编号不能为空", HttpStatus.BAD_REQUEST);
            }
            // 密码不可修改，修改密码走其他方法
            oauthClientDetailsDAO.update(oauthClientDetails);
            logger.debug("更新客户端信息成功" + oauthClientDetails.getClientId());
        } catch (ApiException e) {
            logger.error("更新客户端信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新客户端信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新客户端信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public OauthClientDetails findObj(String clientId) throws ApiException {
        OauthClientDetails obj;
        try {
            obj = oauthClientDetailsDAO.findObj(clientId);
            logger.debug("查询客户端信息成功" + clientId);
        } catch (Exception e) {
            logger.error("查询客户端信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询客户端信息异常", HttpStatus.BAD_REQUEST);
        }
        return obj;
    }
}
