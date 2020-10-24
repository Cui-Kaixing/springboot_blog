package com.ckx.dao;

import com.ckx.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2020/9/24.
 */
@Mapper
@Repository
public interface UserDao {

     User checkUser(@Param("username") String username,@Param("password") String password);


}
