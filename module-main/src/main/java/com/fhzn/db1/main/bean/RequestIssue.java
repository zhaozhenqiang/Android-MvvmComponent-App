package com.fhzn.db1.main.bean;

/**
 * reated by zhaozq on 2020/5/22.
 */
public class RequestIssue {

    /**
     * issueId : 1
     * content : 这个问题1的是讨论内容
     */

    private int issueId;
    private String content;

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
