package com.cloud.springboot.controller;

import com.cloud.springboot.service.DsePipeBaseinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value="/dsePipeBaseinfoController", tags="管道基本信息接口")
@RestController
@RequestMapping("/dsePipeBaseinfoController")
public class DsePipeBaseinfoController {

    @Autowired
    private DsePipeBaseinfoService dsePipeBaseinfoService;

    @ApiOperation(value="查找管道信息", notes = "查找管道信息")
    @GetMapping("/getPipeBaseInfo")
    public String getPipeBaseInfo(){
        return dsePipeBaseinfoService.getPipeBaseInfo();
    }


}
