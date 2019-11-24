package com.damon.bgmt.controller;

import com.damon.bgmt.domain.SysDictionaries;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.SysDictionariesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "字典信息")
@RestController
@RequestMapping("sysDic")
@CrossOrigin
public class SysDictionariesController {

    private SysDictionariesService sysDictionariesService;

    @Autowired
    public void setSysDictionariesService(SysDictionariesService sysDictionariesService) {
        this.sysDictionariesService = sysDictionariesService;
    }

    @ApiOperation(value = "多条件分页查询字典信息列表", notes = "多条件分页查询字典信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "refName", paramType = "query", value = "字典名称"),
            @ApiImplicitParam(name = "refCode", paramType = "query", value = "父节点代码"),
            @ApiImplicitParam(name = "page", paramType = "query", required = true, value = "当前页"),
            @ApiImplicitParam(name = "size", paramType = "query", required = true, value = "每页数")
    })
    @GetMapping("findAll")
    public ResponseEntity<Page<SysDictionaries>> findAll(@Param("refName") String refName, @Param("refCode") String refCode, Pageable pageable) throws ApiException {
        Page<SysDictionaries> page = sysDictionariesService.findAll(refName, refCode, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value = "新增字典", notes = "新增字典")
    @PostMapping("add")
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody SysDictionaries dictionaries) throws ApiException {
        sysDictionariesService.add(dictionaries);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除字典项信息", notes = "删除字典项信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", required = true, paramType = "query", value = "字典编码"),
            @ApiImplicitParam(name = "refCode", required = true, paramType = "query", value = "父字典编码")
    })
    @DeleteMapping("delete")
    public ResponseEntity<HttpStatus> delete(@Param("code") String code,@Param("refCode") String refCode) throws ApiException {
        sysDictionariesService.delete(code,refCode);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新字典项信息", notes = "更新字典项信息")
    @PostMapping("update")
    public ResponseEntity<HttpStatus> update(@Validated @RequestBody SysDictionaries dictionaries) throws ApiException {
        sysDictionariesService.update(dictionaries);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "根据代码查询字典信息", notes = "根据代码查询字典信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", paramType = "query", value = "代码")
    })
    @GetMapping("findObj")
    public ResponseEntity<SysDictionaries> findObj(@Param("code") String code) throws ApiException {
        SysDictionaries obj = sysDictionariesService.findObj(code);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @ApiOperation(value = "根据父字典代码查询字典信息", notes = "根据父字典代码查询字典信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "refCode", paramType = "query", value = "父字典代码")
    })
    @GetMapping("findList")
    public ResponseEntity<List<SysDictionaries>> findList(@Param("refCode") String refCode) throws ApiException {
        List<SysDictionaries> list = sysDictionariesService.findList(refCode);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
