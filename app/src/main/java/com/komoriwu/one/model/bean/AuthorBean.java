package com.komoriwu.one.model.bean;

/**
 * Created by KomoriWu
 * on 2017-11-10.
 */

public class AuthorBean {
        private String user_id;
        private String user_name;
        private String desc;
        private String wb_name;
        private String is_settled;
        private String settled_type;
        private String summary;
        private String fans_total;
        private String web_url;

        public String getUserId() {
            return user_id;
        }

        public void setUserId(String user_id) {
            this.user_id = user_id;
        }

        public String getUserName() {
            return user_name;
        }

        public void setUserName(String user_name) {
            this.user_name = user_name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getWbName() {
            return wb_name;
        }

        public void setWbName(String wb_name) {
            this.wb_name = wb_name;
        }

        public String getIsSettled() {
            return is_settled;
        }

        public void setIsSettled(String is_settled) {
            this.is_settled = is_settled;
        }

        public String getSettledType() {
            return settled_type;
        }

        public void setSettledType(String settled_type) {
            this.settled_type = settled_type;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getFans_total() {
            return fans_total;
        }

        public void setFans_total(String fans_total) {
            this.fans_total = fans_total;
        }

        public String getWebUrl() {
            return web_url;
        }

        public void setWebUrl(String web_url) {
            this.web_url = web_url;
        }
}
