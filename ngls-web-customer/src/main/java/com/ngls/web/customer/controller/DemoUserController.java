package com.ngls.web.customer.controller;


import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.domain.UserDemo;
import com.ngls.user.service.UserDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo-user")
@Api(value = "/demo-user", description = "接口测试")
public class DemoUserController {

    @Autowired
    private UserDemoService userDemoService;

    @RequestMapping(value = "find", method = RequestMethod.GET)
    @ApiOperation(value = "数据库查询测试", notes = "数据库查询测试")
    public ApiResult<UserDemo> find(
            @ApiParam(name = "id", value = "ID")
            @RequestParam("id") Long id) {
        return ApiResult.succ(userDemoService.find(id));
    }

    @RequestMapping(value = "insert", method = RequestMethod.GET)
    @ApiOperation(value = "数据库插入测试", notes = "数据库插入测试")
    public ApiResult<Long> insert(
            @ApiParam(name = "id", value = "ID")
            @RequestParam("id") Long id) {
        UserDemo demo = new UserDemo();
        demo.setName("ngls" + id);
        demo.setAge(id.intValue());

        return ApiResult.succ(userDemoService.insert(demo));
    }

}
