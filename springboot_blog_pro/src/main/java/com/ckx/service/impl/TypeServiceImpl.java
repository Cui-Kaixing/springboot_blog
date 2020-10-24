package com.ckx.service.impl;

import com.ckx.dao.TypeDao;
import com.ckx.domain.Type;
import com.ckx.service.TypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2020/9/26.
 */
@Service
@Transactional
public class TypeServiceImpl  implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public int saveType(String typeName) {
        return typeDao.saveType(typeName);
    }

    @Override
    public Type getType(Long id) {
        return typeDao.getType(id);
    }

    @Override
    public List<Type> findAll(int page, int size) {
        //page是页码值，size是每页显示的条数
        PageHelper.startPage(page,size);
        return typeDao.findAll();
    }

    @Override
    public List<Type> findAll() {
        return typeDao.findAll();
    }


    @Override
    public int updateType(Long id, String typeName) {
        return typeDao.updateType(id,typeName);
    }

    @Override
    public void deleteType(Long id) {
        typeDao.deleteType(id);
    }

    @Override
    public Type findBytypeName(String typeName) {
        return typeDao.findBytypeName(typeName);
    }

    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }
}
