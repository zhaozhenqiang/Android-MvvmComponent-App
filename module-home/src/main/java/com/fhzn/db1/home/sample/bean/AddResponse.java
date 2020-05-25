package com.fhzn.db1.home.sample.bean;

/**
 * reated by zhaozq on 2020/5/25.
 */
public class AddResponse {

    /**
     * result : {"actionType":null,"actionTypeId":99,"content":"test 99","createdAt":1590407475858,"createdBy":429,"createdByUser":null,"id":188,"issueId":99}
     * message : 新建成功！
     * status : 0
     */

    private ResultBean result;
    private String message;
    private int status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * actionType : null
         * actionTypeId : 99
         * content : test 99
         * createdAt : 1590407475858
         * createdBy : 429
         * createdByUser : null
         * id : 188
         * issueId : 99
         */

        private Object actionType;
        private int actionTypeId;
        private String content;
        private long createdAt;
        private int createdBy;
        private Object createdByUser;
        private int id;
        private int issueId;

        public Object getActionType() {
            return actionType;
        }

        public void setActionType(Object actionType) {
            this.actionType = actionType;
        }

        public int getActionTypeId() {
            return actionTypeId;
        }

        public void setActionTypeId(int actionTypeId) {
            this.actionTypeId = actionTypeId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
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
    }
}
