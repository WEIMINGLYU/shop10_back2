package com.ai.shop10_back.dao;

import com.ai.shop10_back.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao {

    User findUserByNameAndPassword(User user);
}
