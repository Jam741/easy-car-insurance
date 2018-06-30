package com.ngls.web.customer.controller;


import com.ngls.common.util.mvc.support.ApiResult;
import com.ngls.user.domain.UserDemo;
import com.ngls.user.domain.UserJpaDemo;
import com.ngls.user.service.UserDemoService;
import com.ngls.user.service.UserJpaDemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-user")
@Api(value = "/demo-user", description = "接口测试")
public class DemoUserController {

    @Autowired
    private UserDemoService userDemoService;

    @Autowired
    private UserJpaDemoService userJpaDemoService;

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

    @RequestMapping(value = "find-jpa", method = RequestMethod.GET)
    @ApiOperation(value = "jpa数据库查询测试", notes = "jpa数据库查询测试")
    public ApiResult<UserJpaDemo> findJpa(
            @ApiParam(name = "id", value = "ID")
            @RequestParam("id") Long id) {
        return ApiResult.succ(userJpaDemoService.find(id));
    }

    @RequestMapping(value = "insert-jpa", method = RequestMethod.GET)
    @ApiOperation(value = "jpa数据库插入测试", notes = "jpa数据库插入测试")
    public ApiResult<Long> insertJpa(
            @ApiParam(name = "id", value = "ID")
            @RequestParam("id") Long id) {
        UserJpaDemo demo = new UserJpaDemo();
        demo.setName("ngls" + id);
        demo.setAge(id.intValue());

        return ApiResult.succ(userJpaDemoService.insert(demo));
    }

}
