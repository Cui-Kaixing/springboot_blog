package com.ckx.domain;

import com.ckx.queryvo.BlogIdAndTagIdQuery;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/9/23.
 */
public class Blog {
    private Long id;
    private Long typeId;
    private Long userId;
    private String title;
    private String content;
    private Integer views;
    private int commentAbled;//是否开启评论
    private Date createTime;
    private Type type;//博客对应的类型
    private List<Tag> tags;//博客对应的标签
    private User user;//博客对应的用户
    private List<Comment> comments;//对应的评论

    private String tagIds="";



    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getCommentAbled() {
        return commentAbled;
    }

    public void setCommentAbled(int commentAbled) {
        this.commentAbled = commentAbled;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
