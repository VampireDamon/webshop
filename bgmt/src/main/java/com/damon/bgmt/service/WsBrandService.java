package com.damon.bgmt.service;

import com.damon.bgmt.domain.WsBrand;
import com.damon.bgmt.exception.ApiException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WsBrandService extends BaseService<WsBrand, Integer> {

    /**
     * 根据条件分页查询品牌信息列表
     *
     * @param name     品牌名称
     * @param isValid  是否启用
     * @param pageable 分页对象
     * @return Page<WsBrand>   品牌信息列表（分页）
     */
    Page<WsBrand> findAll(String name, Integer isValid,
                          Pageable pageable) throws ApiException;

    /**
     * 增加品牌信息
     *
     * @param WsBrand 品牌信息
     * @throws ApiException 异常信息
     */
    void add(WsBrand WsBrand) throws ApiException;

    /**
     * 删除品牌信息
     *
     * @param id 编号
     * @throws ApiException 异常信息
     */
    void delete(String id) throws ApiException;

    /**
     * 更新品牌信息
     *
     * @param WsBrand 品牌信息
     * @throws ApiException 异常信息
     */
    int update(WsBrand WsBrand) throws ApiException;

    /**
     * 查询品牌信息
     *
     * @param id   编号
     * @return WsBrand 品牌信息
     * @throws ApiException 异常信息
     */
    WsBrand findObj(String id) throws ApiException;

}
