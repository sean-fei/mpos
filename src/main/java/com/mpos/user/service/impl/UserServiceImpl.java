package com.mpos.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mpos.user.mapper.UserMapper;
import com.mpos.user.model.User;
import com.mpos.user.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User save(User record) {
        userMapper.insert(record);
        return record;
    }

    @Override
    public int remove(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int update(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> queryTemplate(User record) {
        return userMapper.selectByTemplate(record);
    }

    @Override
    public int countTemplate(User record) {
        return userMapper.countByTemplate(record);
    }

    // 使用pagehelper分页插件
    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     *
     * //将参数传给这个方法就可以实现物理分页了，非常简单。
     *  PageHelper.startPage(pageNum, pageSize);
     */
	@Override
	public PageInfo<User> findAllUser(String userName, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		User record = new User();
		record.setUserName(userName);
		List<User> users = this.queryTemplate(record);
		return new PageInfo<User>(users);
	}
    
}
