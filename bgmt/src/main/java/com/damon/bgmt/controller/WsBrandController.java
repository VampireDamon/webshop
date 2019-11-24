package com.damon.bgmt.controller;

import com.damon.bgmt.domain.WsBrand;
import com.damon.bgmt.exception.ApiException;
import com.damon.bgmt.service.WsBrandService;
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

@Api(tags = "品牌信息")
@RestController
@RequestMapping("wsBrand")
@CrossOrigin
public class WsBrandController {

    private WsBrandService wsBrandService;

    @Autowired
    public void setWsBrandService(WsBrandService wsBrandService) {
        this.wsBrandService = wsBrandService;
    }

    @ApiOperation(value = "多条件分页查询品牌信息列表", notes = "多条件分页查询品牌信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", paramType = "query", value = "名称"),
            @ApiImplicitParam(name = "isValid", paramType = "query", value = "是否有效"),
            @ApiImplicitParam(name = "page", paramType = "query", required = true, value = "当前页"),
            @ApiImplicitParam(name = "size", paramType = "query", required = true, value = "每页数")
    })
    @GetMapping("findAll")
    public ResponseEntity<Page<WsBrand>> findAll(@Param("name") String name,@Param("isValid") Integer isValid,
                                                 @PageableDefault Pageable pageable) throws ApiException {
        Page<WsBrand> page = wsBrandService.findAll(name,isValid, pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @ApiOperation(value = "增加品牌信息", notes = "增加品牌信息")
    @PostMapping("add")
    public ResponseEntity<HttpStatus> add(@Validated @RequestBody WsBrand wsBrand) throws ApiException {
        wsBrandService.add(wsBrand);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "删除品牌信息", notes = "删除品牌信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, paramType = "query", value = "编号")
    })
    @DeleteMapping("delete")
    public ResponseEntity<HttpStatus> delete(String id) throws ApiException {
        wsBrandService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "更新品牌信息", notes = "更新品牌信息")
    @PostMapping("update")
    public ResponseEntity<HttpStatus> update(@Validated @RequestBody WsBrand wsBrand) throws ApiException {
        wsBrandService.update(wsBrand);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "根据条件查询品牌信息", notes = "根据条件查询品牌信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType = "query", value = "编号")
    })
    @GetMapping("findObj")
    public ResponseEntity<WsBrand> findObj(@Param("id") String id) throws ApiException {
        WsBrand obj = wsBrandService.findObj(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
