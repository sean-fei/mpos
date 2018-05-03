package com.mpos.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mpos.user.model.User;

@Repository
public interface UserMapper {

    /**
     * 新建用户
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 根据主键更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 根据ID删除
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(String userId);

    /**
     * 根据ID加载对象
     * @param userId
     * @return
     */
    User selectByPrimaryKey(String userId);

    /**
     * 根据模板查询
     * @param record
     * @return
     */
    List<User> selectByTemplate(User record);

    /**
     * 统计
     * @param record
     * @return
     */
    int countByTemplate(User record);

}
