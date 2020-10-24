package com.ckx.service;

import com.ckx.domain.User;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2020/9/24.
 */
public interface UserService {
    User checkUser(String username,String password) throws NoSuchAlgorithmException;
}
