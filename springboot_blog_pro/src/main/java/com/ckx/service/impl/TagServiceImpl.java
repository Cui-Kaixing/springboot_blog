package com.ckx.service.impl;

import com.ckx.dao.TagDao;
import com.ckx.domain.Tag;
import com.ckx.domain.Type;
import com.ckx.queryvo.BlogIdAndTagIdQuery;
import com.ckx.service.TagService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/9/29.
 */
@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;
    @Override
    public List<Tag> findAll(Integer page, Integer size) {
        //page是页码值，size是每页显示的条数
        PageHelper.startPage(page,size);
        return tagDao.findAll();

    }

    @Override
    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    @Override
    public Type findBytagName(String tagName) {
        return tagDao.findBytagName(tagName);
    }

    @Override
    public int saveTag(String tagName) {
        return tagDao.saveTag(tagName);
    }

    @Override
    public void deleteTag(Long id) {
        tagDao.deleteTag(id);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagDao.findAll();
    }

    @Override
    public Tag getTag(Long id) {
        return tagDao.getTag(id);
    }

    @Override
    public List<Tag> getAllTag(String ids) {
        //将ids拆分
        List<Tag> list = new ArrayList<>();
        if(!"".equals(ids) && ids!=null){
            String[] idarray=ids.split(",");
            for(int i=0;i<idarray.length;i++){
                list.add(tagDao.getTag(new Long(idarray[i])));
            }
        }

        return list;
    }

    @Override
    public List<Integer> getBlogIdsByTagId(Long tagId) {
        return tagDao.getBlogIdsByTagId(tagId);
    }

    @Override
    public void deleteBlogIdAndTagIdByTagId(Long tagId) {
        tagDao.deleteBlogIdAndTagIdByTagId(tagId);
    }
}
