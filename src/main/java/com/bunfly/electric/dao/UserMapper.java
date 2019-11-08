package com.bunfly.electric.dao;

import com.bunfly.electric.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(String useId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String useId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}