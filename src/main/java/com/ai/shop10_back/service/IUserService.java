package com.ai.shop10_back.service;

import com.ai.shop10_back.po.User;

public interface IUserService {

    User findUserByNameAndPassword(User user);
}
