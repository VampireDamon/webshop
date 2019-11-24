package com.damon.bgmt.service.impl;

import com.damon.bgmt.DAO.SysDictionariesDAO;
import com.damon.bgmt.domain.SysDictionaries;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysDictionariesService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDictionariesServiceImpl implements SysDictionariesService {

    private static final Logger logger = LoggerFactory.getLogger(SysDictionariesServiceImpl.class);

    @Resource
    SysDictionariesDAO sysDictionariesDAO;

    @Override
    public Page<SysDictionaries> findAll(String refName, String refCode, Pageable pageable) throws ApiException {
        List<SysDictionaries> list;
        Page<SysDictionaries> page;
        try {
            list = sysDictionariesDAO.findAll(refName, refCode, pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            page = new PageImpl<>(list, pageable, sysDictionariesDAO.findTotal(refName, refCode));
            logger.debug("查询字典信息列表成功");
        } catch (Exception e) {
            logger.error("查询字典信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询字典信息列表查询异常", HttpStatus.BAD_REQUEST);
        }
        return page;
    }

    @Override
    public void add(SysDictionaries sysDictionaries) throws ApiException {
        try {
            if (StringUtils.isBlank(sysDictionaries.getCode())) {
                throw new ApiException("字典代码不能为空", HttpStatus.BAD_REQUEST);
            }
            if (StringUtils.isBlank(sysDictionaries.getRefCode())) {
                throw new ApiException("父字典代码不能为空", HttpStatus.BAD_REQUEST);
            }
            if (sysDictionariesDAO.findObj(sysDictionaries.getCode()) != null) {
                throw new ApiException("该字典代码已存在", HttpStatus.BAD_REQUEST);
            }
            sysDictionariesDAO.add(sysDictionaries);
            logger.debug("添加字典信息成功" + sysDictionaries.getCode());
        } catch (ApiException e) {
            logger.error("添加字典信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加字典信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加字典信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void delete(String code,String refCode) throws ApiException {
        try {
            sysDictionariesDAO.delete(code,refCode);
            logger.debug("删除字典项信息成功" + code);
        } catch (Exception e) {
            logger.error("删除字典项信息异常", e);
            e.printStackTrace();
            throw new ApiException("删除字典项信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void update(SysDictionaries sysDictionaries) throws ApiException {
        try {
            if (StringUtils.isBlank(sysDictionaries.getCode())) {
                throw new ApiException("字典代码不能为空", HttpStatus.BAD_REQUEST);
            }
            if (StringUtils.isBlank(sysDictionaries.getRefCode())) {
                throw new ApiException("父字典代码不能为空", HttpStatus.BAD_REQUEST);
            }
            sysDictionariesDAO.update(sysDictionaries);
            logger.debug("更新字典项信息成功" + sysDictionaries.getCode());
        } catch (ApiException e) {
            logger.error("更新字典项信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新字典项信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新字典项信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysDictionaries findObj(String code) throws ApiException {
        SysDictionaries obj;
        try {
            obj = sysDictionariesDAO.findObj(code);
            logger.debug("查询字典项信息成功" + code);
        } catch (Exception e) {
            logger.error("查询字典项信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询字典项信息异常", HttpStatus.BAD_REQUEST);
        }
        return obj;
    }

    @Override
    public List<SysDictionaries> findList(String refCode) throws ApiException {
        List<SysDictionaries> list;
        try {
            list = sysDictionariesDAO.findList(refCode);
            logger.debug("查询字典项信息列表成功" + refCode);
        } catch (Exception e) {
            logger.error("查询字典项信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询字典项信息列表异常", HttpStatus.BAD_REQUEST);
        }
        return list;
    }


}