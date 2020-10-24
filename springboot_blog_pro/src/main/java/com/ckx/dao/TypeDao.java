package com.ckx.dao;

import com.ckx.domain.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2020/9/26.
 */
@Mapper
@Repository
public interface TypeDao {

    int saveType(String typeName);

    Type getType(Long id);

    int updateType(@Param("id") Long id, @Param("typeName") String typeName);

    void deleteType(Long id);

    List<Type> findAll();

    Type findBytypeName(String typeName);

    List<Type> getAllType();
}
