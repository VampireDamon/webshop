package com.damon.bgmt.controller;

import com.damon.bgmt.domain.SysParam;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysParamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "系统配置信息")
@RestController
@RequestMapping("sysParam")
@CrossOrigin
public class SysParamController {

    private SysParamService sysParamService;

    @Autowired
    public void setSysParamService(SysParamService sysParamService) {
        this.sysParamService = sysParamService;
    }

    @ApiOperation(value = "多条件分页查询系统配置信息列表", notes = "多条件分页查询系统配置信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "query", value = "名称"),
            @ApiImplicitParam(name = "configKey", paramType = "query", value = "配置键"),
            @ApiImplicitParam(name = "page", paramType = "query", required = true, value = "当前页"),
            @ApiImplicitParam(name = "size", paramType = "query", required = true, value = "每页数")
    })
    @GetMapping("findAll")
    public ResponseEntity<Page<SysParam>> findAll(@Param("name") String name, @Param("configKey") String configKey,
                                                  @PageableDefault Pageable pageable) throws ApiException {
        Page<SysParam> page = sysParamService.findAll(name, configKey, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value = "增加系统配置信息", notes = "增加系统配置信息")
    @PostMapping("add")
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysParam sysParam) throws ApiException {
        sysParamService.add(sysParam);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除系统配置信息", notes = "删除系统配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, paramType = "query", value = "编号")
    })
    @DeleteMapping("delete")
    public ResponseEntity<HttpStatus> delete(String id) throws ApiException {
        sysParamService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新系统配置信息", notes = "更新系统配置信息")
    @PostMapping("update")
    public ResponseEntity<HttpStatus> update(@Validated @RequestBody SysParam sysParam) throws ApiException {
        sysParamService.update(sysParam);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "根据条件系统配置信息", notes = "根据条件查询系统配置信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "编号"),
            @ApiImplicitParam(name = "configKey", paramType = "query", value = "配置键")
    })
    @GetMapping("findObj")
    public ResponseEntity<SysParam> findObj(@Param("id") String id,@Param("configKey") String configKey) throws ApiException {
        SysParam obj = sysParamService.findObj(id,configKey);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
