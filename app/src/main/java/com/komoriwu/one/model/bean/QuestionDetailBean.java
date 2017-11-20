package com.komoriwu.one.model.bean;

import java.util.List;

/**
 * Created by KomoriWu
 * on 2017-11-20.
 */

public class QuestionDetailBean {
        private String question_id;
        private String question_title;
        private String question_content;
        private String answer_title;
        private String answer_content;
        private String question_makettime;
        private String recommend_flag;
        private String charge_edt;
        private String charge_email;
        private String last_update_date;
        private String web_url;
        private String read_num;
        private String guide_word;
        private String audio;
        private String anchor;
        private String cover;
        private String content_bgcolor;
        private String cover_media_type;
        private String cover_media_file;
        private String start_video;
        private String copyright;
        private String audio_duration;
        private AuthorBean answerer;
        private AuthorBean asker;
        private int next_id;
        private String previous_id;
        private ShareListBean share_list;
        private int praisenum;
        private int sharenum;
        private int commentnum;
        private List<AuthorBean> author_list;
        private List<AuthorBean> asker_list;
        private List<?> tag_list;

        public String getQuestion_id() {
            return question_id;
        }

        public void setQuestion_id(String question_id) {
            this.question_id = question_id;
        }

        public String getQuestion_title() {
            return question_title;
        }

        public void setQuestion_title(String question_title) {
            this.question_title = question_title;
        }

        public String getQuestionContent() {
            return question_content;
        }

        public void setQuestion_content(String question_content) {
            this.question_content = question_content;
        }

        public String getAnswer_title() {
            return answer_title;
        }

        public void setAnswer_title(String answer_title) {
            this.answer_title = answer_title;
        }

        public String getAnswerContent() {
            return answer_content;
        }

        public void setAnswer_content(String answer_content) {
            this.answer_content = answer_content;
        }

        public String getQuestion_makettime() {
            return question_makettime;
        }

        public void setQuestion_makettime(String question_makettime) {
            this.question_makettime = question_makettime;
        }

        public String getRecommend_flag() {
            return recommend_flag;
        }

        public void setRecommend_flag(String recommend_flag) {
            this.recommend_flag = recommend_flag;
        }

        public String getChargeEdt() {
            return charge_edt;
        }

        public void setCharge_edt(String charge_edt) {
            this.charge_edt = charge_edt;
        }

        public String getChargeEmail() {
            return charge_email;
        }

        public void setCharge_email(String charge_email) {
            this.charge_email = charge_email;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public String getRead_num() {
            return read_num;
        }

        public void setRead_num(String read_num) {
            this.read_num = read_num;
        }

        public String getGuide_word() {
            return guide_word;
        }

        public void setGuide_word(String guide_word) {
            this.guide_word = guide_word;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public String getAnchor() {
            return anchor;
        }

        public void setAnchor(String anchor) {
            this.anchor = anchor;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getContent_bgcolor() {
            return content_bgcolor;
        }

        public void setContent_bgcolor(String content_bgcolor) {
            this.content_bgcolor = content_bgcolor;
        }

        public String getCover_media_type() {
            return cover_media_type;
        }

        public void setCover_media_type(String cover_media_type) {
            this.cover_media_type = cover_media_type;
        }

        public String getCover_media_file() {
            return cover_media_file;
        }

        public void setCover_media_file(String cover_media_file) {
            this.cover_media_file = cover_media_file;
        }

        public String getStart_video() {
            return start_video;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getAudio_duration() {
            return audio_duration;
        }

        public void setAudio_duration(String audio_duration) {
            this.audio_duration = audio_duration;
        }

        public AuthorBean getAnswerer() {
            return answerer;
        }

        public void setAnswerer(AuthorBean answerer) {
            this.answerer = answerer;
        }

        public AuthorBean getAsker() {
            return asker;
        }

        public void setAsker(AuthorBean asker) {
            this.asker = asker;
        }

        public int getNext_id() {
            return next_id;
        }

        public void setNext_id(int next_id) {
            this.next_id = next_id;
        }

        public String getPrevious_id() {
            return previous_id;
        }

        public void setPrevious_id(String previous_id) {
            this.previous_id = previous_id;
        }

        public ShareListBean getShare_list() {
            return share_list;
        }

        public void setShare_list(ShareListBean share_list) {
            this.share_list = share_list;
        }

        public int getPraisenum() {
            return praisenum;
        }

        public void setPraisenum(int praisenum) {
            this.praisenum = praisenum;
        }

        public int getSharenum() {
            return sharenum;
        }

        public void setSharenum(int sharenum) {
            this.sharenum = sharenum;
        }

        public int getCommentnum() {
            return commentnum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        public List<AuthorBean> getAuthor_list() {
            return author_list;
        }

        public void setAuthor_list(List<AuthorBean> author_list) {
            this.author_list = author_list;
        }

        public List<AuthorBean> getAsker_list() {
            return asker_list;
        }

        public void setAsker_list(List<AuthorBean> asker_list) {
            this.asker_list = asker_list;
        }

        public List<?> getTag_list() {
            return tag_list;
        }

        public void setTag_list(List<?> tag_list) {
            this.tag_list = tag_list;
        }


}
