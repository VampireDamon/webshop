package com.damon.bgmt.controller;

import com.damon.bgmt.domain.SysRole;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysRoleService;
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

@Api(tags = "角色信息")
@RestController
@RequestMapping("sysRole")
@CrossOrigin
public class SysRoleController {

    private SysRoleService sysRoleService;

    @Autowired
    public void setSysRoleService(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @ApiOperation(value = "多条件分页查询角色信息列表", notes = "多条件分页查询角色信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "query", value = "名称"),
            @ApiImplicitParam(name = "isValid", paramType = "query", value = "是否有效"),
            @ApiImplicitParam(name = "page", paramType = "query", required = true, value = "当前页"),
            @ApiImplicitParam(name = "size", paramType = "query", required = true, value = "每页数")
    })
    @GetMapping("findAll")
    public ResponseEntity<Page<SysRole>> findAll(@Param("name") String name,@Param("isValid") Integer isValid,
                                                 @PageableDefault Pageable pageable) throws ApiException {
        Page<SysRole> page = sysRoleService.findAll(name,isValid, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value = "增加角色信息", notes = "增加角色信息")
    @PostMapping("add")
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysRole sysRole) throws ApiException {
        sysRoleService.add(sysRole);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除角色信息", notes = "删除角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, paramType = "query", value = "编号")
    })
    @DeleteMapping("delete")
    public ResponseEntity<HttpStatus> delete(String id) throws ApiException {
        sysRoleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新角色信息", notes = "更新角色信息")
    @PostMapping("update")
    public ResponseEntity<HttpStatus> update(@Validated @RequestBody SysRole sysRole) throws ApiException {
        sysRoleService.update(sysRole);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "根据条件查询角色信息", notes = "根据条件查询角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "编号"),
            @ApiImplicitParam(name = "name", paramType = "query", value = "角色名称")
    })
    @GetMapping("findObj")
    public ResponseEntity<SysRole> findObj(@Param("id") String id,@Param("name") String name) throws ApiException {
        SysRole obj = sysRoleService.findObj(id,name);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
