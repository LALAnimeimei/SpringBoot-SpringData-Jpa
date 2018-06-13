package com.boottest.fortest.Entity;

import java.util.List;

public class TreeNode {
    private long id;
    private  long pid;
    private String text;
    private String url;
    private List<TreeNode> children;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getPid() {
        return pid;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}
