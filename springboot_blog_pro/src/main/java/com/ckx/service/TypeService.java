package com.ckx.service;

import com.ckx.domain.Type;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.List;


/**
 * Created by Administrator on 2020/9/26.
 */
public interface TypeService {

    int saveType(String typeName);

    Type getType(Long id);

    //分页查询
    List<Type> findAll(int page, int size);

    List<Type> findAll();

    int updateType(Long id,String typeName);

    void deleteType(Long id);

    Type findBytypeName(String typeName);

    List<Type> getAllType();
}
