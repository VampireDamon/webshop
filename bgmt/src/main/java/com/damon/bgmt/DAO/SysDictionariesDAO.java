package com.damon.bgmt.DAO;

import com.damon.bgmt.domain.SysDictionaries;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysDictionariesDAO {

    /**
     * 根据字典名称分页查询字典信息
     *
     * @param refName   字典名称
     * @param refCode   字典代码
     * @param pageStart 开始页
     * @param pageSize  页条数
     * @return List<SysDictionaries> 字典信息列表
     * @throws Exception 异常
     */
    List<SysDictionaries> findAll(@Param("refName") String refName, @Param("refCode") String refCode,
                                  @Param("pageStart") int pageStart, @Param("pageSize") int pageSize) throws Exception;

    /**
     * 根据字典名称查询字典总数
     *
     * @param refName 字典名称
     * @param refCode 字典代码
     * @return 字典总数
     * @throws Exception 异常
     */
    int findTotal(@Param("refName") String refName, @Param("refCode") String refCode) throws Exception;

    /**
     * 添加字典对象
     *
     * @param sysDictionaries 字典对象
     * @return 插入总数
     * @throws Exception 异常
     */
    int add(SysDictionaries sysDictionaries) throws Exception;

    /**
     * 删除字典项信息
     *
     * @param code 字典代码
     * @param refCode 父字典代码
     * @throws Exception 异常
     */
    void delete(@Param("code") String code,@Param("refCode") String refCode) throws Exception;

    /**
     * 更新字典信息
     *
     * @param sysDictionaries 字典对象
     * @throws Exception 异常
     */
    void update(SysDictionaries sysDictionaries) throws Exception;

    /**
     * 通过条件获取字典信息
     *
     * @param code 字典代码
     * @return 字典信息
     * @throws Exception 异常
     */
    SysDictionaries findObj(@Param("code") String code) throws Exception;

    /**
     * 通过条件获取字典内容列表信息
     *
     * @param refCode 父节点代码
     * @return 字典信息
     * @throws Exception 异常
     */
    List<SysDictionaries> findList(@Param("refCode") String refCode) throws Exception;

}
