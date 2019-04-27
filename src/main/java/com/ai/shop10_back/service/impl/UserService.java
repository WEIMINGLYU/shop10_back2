package com.ai.shop10_back.service.impl;

import com.ai.shop10_back.dao.IUserDao;
import com.ai.shop10_back.po.User;
import com.ai.shop10_back.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements IUserService {

    @Resource
    private IUserDao userDao;
    @Override
    public User findUserByNameAndPassword(User user) {
        return userDao.findUserByNameAndPassword(user);
    }
}
