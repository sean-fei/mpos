package com.mpos.user.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.mpos.user.model.User;

public interface UserService {

    User save(User record);

    int remove(String userId);

    int update(User record);

    List<User> queryTemplate(User record);

    int countTemplate(User record);

    PageInfo<User> findAllUser(String userName, int pageNum, int pageSize);
    
}
