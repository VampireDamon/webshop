package com.damon.bgmt.service.impl;

import com.damon.bgmt.IDAO.BaseDAO;
import com.damon.bgmt.DAO.WsBrandDAO;
import com.damon.bgmt.domain.WsBrand;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.WsBrandService;
import com.damon.bgmt.utils.DamonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class WsBrandServiceImpl extends BaseServiceImpl<WsBrand, Integer> implements WsBrandService {

    private static final Logger logger = LoggerFactory.getLogger(WsBrandServiceImpl.class);

/*    @Resource
    WsBrandDAO WsBrandDAO;*/

    @Autowired
    private WsBrandDAO wsBrandDAO;

    @Override
    protected BaseDAO<WsBrand> getDao() {
        return wsBrandDAO;
    }

    @Override
    public Page<WsBrand> findAll(String name, Integer isValid,
                                 Pageable pageable) throws ApiException {
        List<WsBrand> list;
        Page<WsBrand> page;
        RowBounds rowBounds = new RowBounds();
        WsBrand wsBrand = new WsBrand();
        try {
            wsBrandDAO.selectByRowBounds(wsBrand, rowBounds);
            list = wsBrandDAO.findAll(name, isValid, pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
            page = new PageImpl<>(list, pageable, wsBrandDAO.findTotal(name, isValid));
            logger.debug("查询品牌信息列表成功");
        } catch (Exception e) {
            logger.error("查询品牌信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询品牌信息列表异常", HttpStatus.BAD_REQUEST);
        }
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(WsBrand WsBrand) throws ApiException {
        try {
            if (StringUtils.isBlank(WsBrand.getId())) {
                WsBrand.setId(DamonUtil.getUUID(true));
            }
            wsBrandDAO.insert(WsBrand);
            logger.debug("添加品牌信息成功" + WsBrand.getName());
        } catch (ApiException e) {
            logger.error("添加品牌信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加品牌信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加品牌信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            wsBrandDAO.deleteByPrimaryKey(id);
            logger.debug("删除品牌信息成功" + id);
        } catch (Exception e) {
            logger.error("删除品牌信息异常", e);
            e.printStackTrace();
            throw new ApiException("删除品牌信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(WsBrand WsBrand) throws ApiException {
        int ret;
        try {

            if (StringUtils.isBlank(WsBrand.getId())) {
                throw new ApiException("编号不能为空", HttpStatus.BAD_REQUEST);
            }
            // 密码不可修改，修改密码走其他方法
            ret = wsBrandDAO.updateByPrimaryKey(WsBrand);
            logger.debug("更新品牌信息成功" + WsBrand.getId());
        } catch (ApiException e) {
            logger.error("更新品牌信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新品牌信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新品牌信息异常", HttpStatus.BAD_REQUEST);
        }
        return ret;
    }

    @Override
    public WsBrand findObj(String id) throws ApiException {
        WsBrand obj;
        WsBrand param = new WsBrand();
        param.setId(id);
        try {
            obj = wsBrandDAO.selectOne(param);
            logger.debug("查询品牌信息成功" + id);
        } catch (Exception e) {
            logger.error("查询品牌信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询品牌信息异常", HttpStatus.BAD_REQUEST);
        }
        return obj;
    }
}
