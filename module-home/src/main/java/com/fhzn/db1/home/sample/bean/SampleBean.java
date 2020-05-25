package com.fhzn.db1.home.sample.bean;

import com.fhzn.common.contract.BaseCustomViewModel;

/**
 * reated by zhaozq on 2020/5/25.
 */
public class SampleBean extends BaseCustomViewModel {
    /**
     * actionType : {"id":1,"name":"提报了问题"}
     * actionTypeId : 1
     * content : null
     * createdAt : 1589556090000
     * createdBy : 411
     * createdByUser : null
     * id : 72
     * issueId : 34
     */

    public ActionTypeBean actionType;
    private int actionTypeId;
    private Object content;
    private long createdAt;
    private int createdBy;
    private Object createdByUser;
    private int id;
    private int issueId;

    public ActionTypeBean getActionType() {
        return actionType;
    }

    public void setActionType(ActionTypeBean actionType) {
        this.actionType = actionType;
    }

    public int getActionTypeId() {
        return actionTypeId;
    }

    public void setActionTypeId(int actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Object getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(Object createdByUser) {
        this.createdByUser = createdByUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public static class ActionTypeBean {
        /**
         * id : 1
         * name : 提报了问题
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
