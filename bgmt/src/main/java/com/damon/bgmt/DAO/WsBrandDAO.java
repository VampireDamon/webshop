package com.damon.bgmt.DAO;
import com.damon.bgmt.IDAO.BaseDAO;
import com.damon.bgmt.domain.WsBrand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2019/11/22.
 *
 * @author XX
 */
@Repository
public interface WsBrandDAO extends BaseDAO<WsBrand> {

    /**
     * 根据条件查询品牌信息列表
     *
     * @param name      品牌名称
     * @param isValid   是否启用
     * @param pageStart 开始页
     * @param pageSize  页条数
     * @return 品牌信息列表
     * @throws Exception 异常
     */
    List<WsBrand> findAll(@Param("name") String name,
                          @Param("isValid") Integer isValid,
                          @Param("pageStart") int pageStart, @Param("pageSize") int pageSize) throws Exception;


    /**
     * 查询品牌信息总数
     *
     * @param name    品牌名称
     * @param isValid 是否启用
     * @return 品牌总数
     * @throws Exception 异常
     */
    int findTotal(@Param("name") String name,
                  @Param("isValid") Integer isValid) throws Exception;
}
