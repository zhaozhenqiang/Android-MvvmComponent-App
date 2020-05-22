package com.fhzn.db1.user.bean;

/**
 * reated by zhaozq on 2020/5/22.
 */
public class LoginResponse {

    /**
     * result : {"userTypeId":1,"avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIXhEFUdLia17iaCfqskSnYWM1BOef6SWjWNyp8X9AKcNOVpsjbiab7HOSb8hDm0qkDwewkcEbcx8Kdg/132","nickName":"东峰","spoAccount":null,"weixinNo":null,"userName":"wangdongfeng","userId":429,"email":null,"cellPhone":null,"qunName":null,"token":"eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6IiIsInN1YiI6IntcInVzZXJOYW1lXCI6XCJ3YW5nZG9uZ2ZlbmdcIixcInVzZXJJZFwiOjQyOX0iLCJleHAiOjE1OTAyODQwOTB9.eSuZytRNZVNAWrl6svcYlLl1nyNqiN-PeN7GsllwIXX0UTYfNeElphoHtzRdgLu1Nd6vCqy6sC-FgrS8eGNQHg"}
     * message : 微信登录成功
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
         * userTypeId : 1
         * avatarUrl : https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIXhEFUdLia17iaCfqskSnYWM1BOef6SWjWNyp8X9AKcNOVpsjbiab7HOSb8hDm0qkDwewkcEbcx8Kdg/132
         * nickName : 东峰
         * spoAccount : null
         * weixinNo : null
         * userName : wangdongfeng
         * userId : 429
         * email : null
         * cellPhone : null
         * qunName : null
         * token : eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6IiIsInN1YiI6IntcInVzZXJOYW1lXCI6XCJ3YW5nZG9uZ2ZlbmdcIixcInVzZXJJZFwiOjQyOX0iLCJleHAiOjE1OTAyODQwOTB9.eSuZytRNZVNAWrl6svcYlLl1nyNqiN-PeN7GsllwIXX0UTYfNeElphoHtzRdgLu1Nd6vCqy6sC-FgrS8eGNQHg
         */

        private int userTypeId;
        private String avatarUrl;
        private String nickName;
        private Object spoAccount;
        private Object weixinNo;
        private String userName;
        private int userId;
        private Object email;
        private Object cellPhone;
        private Object qunName;
        private String token;

        public int getUserTypeId() {
            return userTypeId;
        }

        public void setUserTypeId(int userTypeId) {
            this.userTypeId = userTypeId;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public Object getSpoAccount() {
            return spoAccount;
        }

        public void setSpoAccount(Object spoAccount) {
            this.spoAccount = spoAccount;
        }

        public Object getWeixinNo() {
            return weixinNo;
        }

        public void setWeixinNo(Object weixinNo) {
            this.weixinNo = weixinNo;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getCellPhone() {
            return cellPhone;
        }

        public void setCellPhone(Object cellPhone) {
            this.cellPhone = cellPhone;
        }

        public Object getQunName() {
            return qunName;
        }

        public void setQunName(Object qunName) {
            this.qunName = qunName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
