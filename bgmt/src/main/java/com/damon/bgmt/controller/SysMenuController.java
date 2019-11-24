package com.damon.bgmt.controller;

import com.damon.bgmt.domain.SysMenu;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysMenuService;
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

@Api(tags = "菜单信息")
@RestController
@RequestMapping("sysMenu")
@CrossOrigin
public class SysMenuController {

    private SysMenuService sysMenuService;

    @Autowired
    public void setSysMenuService(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    @ApiOperation(value = "多条件分页查询菜单信息列表", notes = "多条件分页查询菜单信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "query", value = "名称"),
            @ApiImplicitParam(name = "isValid", paramType = "query", value = "是否有效"),
            @ApiImplicitParam(name = "page", paramType = "query", required = true, value = "当前页"),
            @ApiImplicitParam(name = "size", paramType = "query", required = true, value = "每页数")
    })
    @GetMapping("findAll")
    public ResponseEntity<Page<SysMenu>> findAll(@Param("name") String name,@Param("isValid") Integer isValid,
                                                 @PageableDefault Pageable pageable) throws ApiException {
        Page<SysMenu> page = sysMenuService.findAll(name,isValid, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value = "增加菜单信息", notes = "增加菜单信息")
    @PostMapping("add")
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysMenu sysMenu) throws ApiException {
        sysMenuService.add(sysMenu);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除菜单信息", notes = "删除菜单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, paramType = "query", value = "编号")
    })
    @DeleteMapping("delete")
    public ResponseEntity<HttpStatus> delete(String id) throws ApiException {
        sysMenuService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新菜单信息", notes = "更新菜单信息")
    @PostMapping("update")
    public ResponseEntity<HttpStatus> update(@Validated @RequestBody SysMenu sysMenu) throws ApiException {
        sysMenuService.update(sysMenu);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "根据条件查询菜单信息", notes = "根据条件查询菜单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "编号"),
            @ApiImplicitParam(name = "name", paramType = "query", value = "菜单名称")
    })
    @GetMapping("findObj")
    public ResponseEntity<SysMenu> findObj(@Param("id") String id,@Param("name") String name) throws ApiException {
        SysMenu obj = sysMenuService.findObj(id,name);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
