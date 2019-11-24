package com.damon.bgmt.controller;

import com.damon.bgmt.domain.SysUser;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysUserService;
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

@Api(tags = "用户信息")
@RestController
@RequestMapping("sysUser")
@CrossOrigin
public class SysUserController {

    private SysUserService sysUserService;

    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @ApiOperation(value = "多条件分页查询用户信息列表", notes = "多条件分页查询用户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "query", value = "名称"),
            @ApiImplicitParam(name = "cardId", paramType = "query", value = "身份证号"),
            @ApiImplicitParam(name = "birthday", paramType = "query", value = "生日"),
            @ApiImplicitParam(name = "phone", paramType = "query", value = "手机号"),
            @ApiImplicitParam(name = "sex", paramType = "query", value = "性别"),
            @ApiImplicitParam(name = "loginAccount", paramType = "query", value = "登录账号"),
            @ApiImplicitParam(name = "isValid", paramType = "query", value = "是否有效"),
            @ApiImplicitParam(name = "page", paramType = "query", required = true, value = "当前页"),
            @ApiImplicitParam(name = "size", paramType = "query", required = true, value = "每页数")
    })
    @GetMapping("findAll")
    public ResponseEntity<Page<SysUser>> findAll(@Param("name") String name, @Param("cardId") String cardId,
                                                 @Param("birthday") String birthday, @Param("phone") String phone,
                                                 @Param("sex") Integer sex, @Param("loginAccount") String loginAccount,
                                                 @Param("isValid") Integer isValid,
                                                 @PageableDefault Pageable pageable) throws ApiException {
        Page<SysUser> page = sysUserService.findAll(name, cardId, birthday, phone, sex, loginAccount, isValid, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value = "增加用户信息", notes = "增加用户信息")
    @PostMapping("add")
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysUser sysUser) throws ApiException {
        sysUserService.add(sysUser);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, paramType = "query", value = "编号")
    })
    @DeleteMapping("delete")
    public ResponseEntity<HttpStatus> delete(String id) throws ApiException {
        sysUserService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @PostMapping("update")
    public ResponseEntity<HttpStatus> update(@Validated @RequestBody SysUser sysUser) throws ApiException {
        sysUserService.update(sysUser);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "根据条件查询用户信息", notes = "根据条件查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "编号"),
            @ApiImplicitParam(name = "loginAccount", paramType = "query", value = "登录账号")
    })
    @GetMapping("findObj")
    public ResponseEntity<SysUser> findObj(@Param("id") String id,@Param("loginAccount") String loginAccount) throws ApiException {
        SysUser obj = sysUserService.findObj(id,loginAccount);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
