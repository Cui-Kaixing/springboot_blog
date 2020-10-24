package com.ckx.queryvo;

/**
 * Created by Administrator on 2020/10/9.
 */
public class BlogQuery {
    private String title;
    private Long typeId;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}
