package com.ckx.service.impl;


import com.ckx.dao.UserDao;
import com.ckx.domain.User;
import com.ckx.service.UserService;
import com.ckx.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2020/9/24.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User checkUser(String username, String password) throws NoSuchAlgorithmException {
        User user=userDao.checkUser(username, MD5Utils.code(password));
        return user;
    }
}
