package com.cloud.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TSysMessageController
 * @Company: 深圳市东深电子股份有限公司
 * @Auther: leichengyang
 * @Date: 2019/3/20 0020
 * @Version 1.0
 */
@Api(value = "/tSysMessageController", tags = "消息接口")
@RestController
@RequestMapping("/tSysMessageController")
public class TSysMessageController {

    @ApiOperation(value="查询消息", notes = "查询消息")
    @GetMapping("/getSysMessage")
    public String getSysMessage(String message){
        String result = message;
        return result;
    }
}
