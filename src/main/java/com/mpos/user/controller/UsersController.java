package com.mpos.user.controller;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mpos.common.GeneralResponse;
import com.mpos.user.model.User;
import com.mpos.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
@Api(tags = { "用户管理接口" }, value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "创建用户")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "创建用户成功", response = User.class)
    })
    @PostMapping("")
    public GeneralResponse createUser(@ApiParam(value = "用户对象", required = true) @RequestBody User record) {
        User user = userService.save(record);
    	return GeneralResponse.success(user);
    }

    @ApiOperation(value = "修改用户")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "修改用户成功", response = Integer.class)
    })
    @PutMapping("/{userId}")
    public GeneralResponse updateUser(
            @NotEmpty(message = "用户ID不能为空") 
            @ApiParam(value = "用户ID", required = true) @PathVariable String userId,
            @ApiParam(value = "用户对象", required = true) @RequestBody User record) {
        return GeneralResponse.success(userService.update(record));
    }

    @ApiOperation(value = "删除用户")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "删除用户成功", response = Integer.class)
    })
    @DeleteMapping("/{userId}")
    public GeneralResponse delUser(
            @NotEmpty(message = "用户ID不能为空") 
            @ApiParam(value = "用户ID", required = true) @PathVariable String userId) {
        return GeneralResponse.success(userService.remove(userId));
    }

    @ApiOperation(value = "用户查询")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "查询用户成功", response = User.class)
    })
//    @JsonFilter(type = User.class,exclude = "gitPassword")//把gitPassword字段过滤掉
    @GetMapping("")
    public GeneralResponse queryUsers(
    		@ApiParam(value = "用户名称", required = false) @RequestParam(value="userName", required = false) String userName,
    		@ApiParam(value = "开始页数", required = false) @RequestParam(value="pageNum", required = false) String pageNum,
    		@ApiParam(value = "每页显示的数据条数", required = false) @RequestParam(value="pageSize", required = false) String pageSize
    		) {
        if(!StringUtils.isBlank(pageSize) || !StringUtils.isBlank(pageNum)) {
        	int num = Integer.valueOf(pageNum);
        	int size = Integer.valueOf(pageSize);
        	return GeneralResponse.success(userService.findAllUser(userName, num, size));
        } else {
        	User record = new User();
        	record.setUserName(userName);
        	return GeneralResponse.success(userService.queryTemplate(record));
        }
    	
    }
    
}
